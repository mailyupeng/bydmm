package ttmy.framework.core.cache;

import org.springframework.stereotype.Component;

import ttmy.framework.cache.KeyValueCache;
import ttmy.framework.core.dao.IUserProvider;
import ttmy.framework.core.module.IUser;
import ttmy.framework.util.BeanUtils;

@Component("userCache")
public class UserCache extends KeyValueCache<Long, IUser> {

	@Override
	protected IUser loadData(Long key) {
		IUserProvider userProvider = BeanUtils.getBean("userProvider");
		return userProvider.loadUser(key);
	}

}
