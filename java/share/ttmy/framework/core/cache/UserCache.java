package ttmy.framework.core.cache;

import org.springframework.stereotype.Component;

import ttmy.framework.cache.KeyValueCache;
import ttmy.framework.core.dao.IUserProvider;
import ttmy.framework.core.model.IUser;
import ttmy.framework.util.BeanUtils;

@Component("userCache")
public class UserCache extends KeyValueCache<Long, IUser> {

	@Override
	protected IUser loadData(Long key) {
		IUserProvider userProvider = BeanUtils.getBean("userProvider");
		IUser user = userProvider.loadUser(key);
		IUser res = new IUser() {

			@Override
			public Long getId() {
				return user.getId();
			}

			@Override
			public String getName() {
				return user.getName();
			}

			@Override
			public int getStatus() {
				return user.getStatus();
			}

		};
		return res;
	}

}
