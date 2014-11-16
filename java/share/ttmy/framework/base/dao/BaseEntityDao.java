package ttmy.framework.base.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import ttmy.framework.base.model.BaseEntity;

public class BaseEntityDao<E extends BaseEntity> extends HibernateDaoSupport implements IEntityDao<E> {

	protected final Class<E> entityClass;

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

	protected Log log = LogFactory.getLog(entityClass);
}
