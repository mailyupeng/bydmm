package ttmy.framework.core.cache;

import ttmy.framework.cache.KeyValueCache;
import ttmy.framework.core.dao.IRoleProvider;
import ttmy.framework.core.module.IRole;
import ttmy.framework.util.BeanUtils;

public class RoleCache extends KeyValueCache<Long, IRole> {

	@Override
	protected IRole loadData(Long key) {
		IRoleProvider provider = BeanUtils.getBean("roleProvider");
		return provider.loadRole(key);
	}

}
