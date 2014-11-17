package ttmy.module.frameworkimpl.dao;

import ttmy.framework.base.dao.IEntityDao;
import ttmy.module.frameworkimpl.model.Role;
import ttmy.module.frameworkimpl.model.User;
import ttmy.module.frameworkimpl.model.UserRole;

public interface IUserDao extends IEntityDao<User> {

	User loadByUsername(String username);
	
	UserRole loadUserRole(Long userId, Long roleId);
	
	Role loadUserDefaultRole(Long userId);

}
