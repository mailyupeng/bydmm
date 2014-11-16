package ttmy.framework.core.cache;

import java.util.Collections;
import java.util.List;

import ttmy.framework.cache.KeyValueCache;
import ttmy.framework.core.dao.IRoleProvider;
import ttmy.framework.core.model.IModule;
import ttmy.framework.core.model.IRole;
import ttmy.framework.util.BeanUtils;

public class RoleCache extends KeyValueCache<Long, IRole> {

	@Override
	protected IRole loadData(Long key) {
		IRoleProvider provider = BeanUtils.getBean("roleProvider");
		IRole role = provider.loadRole(key);
		List<IModule> authModules = provider.loadRoleModules(key);
		IRole res = new IRole() {

			@Override
			public Long getId() {
				return role.getId();
			}

			@Override
			public String getName() {
				return role.getName();
			}

			@Override
			public List<IModule> getAuthModules() {
				return Collections.unmodifiableList(authModules);
			}

		};
		return res;
	}
}
