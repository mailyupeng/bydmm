package ttmy.module.frameworkimpl.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import ttmy.framework.base.dao.BaseEntityDao;
import ttmy.framework.core.dao.IUserProvider;
import ttmy.framework.core.model.IUser;
import ttmy.module.frameworkimpl.model.Role;
import ttmy.module.frameworkimpl.model.User;
import ttmy.module.frameworkimpl.model.UserRole;

@Repository("userProvider")
public class UserDao extends BaseEntityDao<User> implements IUserDao, IUserProvider {

	@Resource(name = "roleProvider")
	private IRoleDao roleDao;

	@Override
	public IUser loadUser(long userId) {
		return super.findById(userId);
	}

	@Override
	public User loadByUsername(String username) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(super.entityClass);
		detachedCriteria.add(Restrictions.eq("name", username));
		return super.findUniqueBy(detachedCriteria);
	}

	@Override
	public UserRole loadUserRole(Long userId, Long roleId) {
		return super.getHibernateTemplate().execute(new HibernateCallback<UserRole>() {
			public UserRole doInHibernate(Session sess) throws HibernateException {
				return (UserRole) sess.createCriteria(UserRole.class).add(Restrictions.eq("userId", userId))
						.add(Restrictions.eq("roleId", roleId)).uniqueResult();
			}
		});
	}

	@Override
	public Role loadUserDefaultRole(Long userId) {
		UserRole ur = super.getHibernateTemplate().execute(new HibernateCallback<UserRole>() {
			public UserRole doInHibernate(Session sess) throws HibernateException {
				return (UserRole) sess.createCriteria(UserRole.class).add(Restrictions.eq("userId", userId))
						.add(Restrictions.eq("isDefault", 1L)).uniqueResult();
			}
		});
		if (ur != null) {
			return roleDao.findById(ur.getRoleId());
		}
		return null;
	}

}
