package ttmy.framework.base.model;

import ttmy.framework.cache.ICache;
import ttmy.framework.context.UserContext;
import ttmy.framework.util.BeanUtils;

public interface IUser {
	
	long getId();

	default IRole getCurrentRole() {
		ICache<Long, IRole> cache = BeanUtils.getBean("roleCache");
		return cache.getData(UserContext.getRoleId());
	}

}
