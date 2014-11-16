package ttmy.framework.core.dao;

import ttmy.framework.core.module.IUser;

public interface IUserProvider {

	IUser loadUser(long userId);

}
