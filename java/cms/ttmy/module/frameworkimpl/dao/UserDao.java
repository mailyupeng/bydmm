package ttmy.module.frameworkimpl.dao;

import org.springframework.stereotype.Repository;

import ttmy.framework.base.dao.BaseEntityDao;
import ttmy.framework.core.dao.IUserProvider;
import ttmy.framework.core.model.IUser;
import ttmy.module.frameworkimpl.model.User;

@Repository("userProvider")
public class UserDao extends BaseEntityDao<User> implements IUserProvider {

	@Override
	public IUser loadUser(long userId) {
		return super.findById(userId);
	}

}
