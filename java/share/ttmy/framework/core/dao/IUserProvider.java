package ttmy.framework.core.dao;

import ttmy.framework.core.model.IUser;

public interface IUserProvider {

	IUser loadUser(long userId);

}
