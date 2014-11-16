package ttmy.framework.core.model;

import ttmy.framework.cache.ICache;
import ttmy.framework.context.UserContext;
import ttmy.framework.util.BeanUtils;

public interface IUser {

	int ROOT = 0;
	int ENABLE = 1;
	int DISABLE = 2;

	Long getId();

	default IRole getCurrentRole() {
		ICache<Long, IRole> cache = BeanUtils.getBean("roleCache");
		return cache.getData(UserContext.getRoleId());
	}

	String getName();

	int getStatus();

}
