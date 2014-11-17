package ttmy.framework.base.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import ttmy.framework.base.model.BaseEntity;
import ttmy.framework.core.IPage;
import ttmy.framework.core.Page;

public class BaseEntityDao<E extends BaseEntity> extends HibernateDaoSupport implements IEntityDao<E> {

	protected final Class<E> entityClass;
	protected Log log = LogFactory.getLog(this.getClass());

	{
		this.entityClass = getInitEntityClass();
		if (this.entityClass == null) {
			String clsName = getClass().getSimpleName();
			throw new RuntimeException(getClass().getCanonicalName() + "未定义泛型! 继承于:"
					+ BaseEntityDao.class.getCanonicalName() + "的类都必需声明所操作实体的泛型, 如:\npublic class " + clsName
					+ " extends " + BaseEntityDao.class.getSimpleName() + "<"
					+ clsName.substring(0, clsName.length() - 3) + "> implements I" + clsName + "{\n\t...\n}");
		}
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getInitEntityClass() {
		Class<E> cls = getEntityTypeFromClass(getClass());
		if (cls == null) {
			cls = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return cls;
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getEntityTypeFromClass(Class<?> beanClass) {
		if (BaseEntityDao.class.isAssignableFrom(beanClass)) {
			Type type = beanClass.getGenericSuperclass();
			if ((type != null) && (ParameterizedType.class.isInstance(type))) {
				ParameterizedType pType = (ParameterizedType) type;
				if (pType.getRawType().equals(BaseEntityDao.class)) {
					Type argType = pType.getActualTypeArguments()[0];
					if ((argType instanceof Class)) {
						return (Class<E>) argType;
					}
					return null;
				}
			}
			return getEntityTypeFromClass(beanClass.getSuperclass());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<E> findBy(DetachedCriteria detachedCriteria) {
		return (List<E>) super.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	public E findUniqueBy(DetachedCriteria detachedCriteria) {
		List<E> list = findBy(detachedCriteria);
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	public List<E> findAll() {
		return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
			@SuppressWarnings("unchecked")
			public List<E> doInHibernate(Session session) throws HibernateException {
				return (List<E>) session.createCriteria(BaseEntityDao.this.entityClass).list();
			}
		});
	}

	public E findById(Long id) {
		return super.getHibernateTemplate().get(this.entityClass, id);
	}

	public IPage<E> findPageBy(DetachedCriteria detachedCriteria, final int pageSize, final int pageIndex) {
		return super.getHibernateTemplate().execute(new HibernateCallback<IPage<E>>() {
			@SuppressWarnings("unchecked")
			@Override
			public IPage<E> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				int rowCount = (Integer) criteria.setProjection(  
		                Projections.rowCount()).uniqueResult();  
		        criteria.setProjection(null);  
		  
		        criteria.setFirstResult((pageIndex - 1) * pageSize);  
		        criteria.setMaxResults(pageSize);  
		  
		        List<E> result = criteria.list();  
				return new Page(result, rowCount, pageSize, pageIndex);
			}
		});
	}
}
