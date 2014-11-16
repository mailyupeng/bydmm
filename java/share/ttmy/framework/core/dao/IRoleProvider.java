package ttmy.framework.core.dao;

import java.util.List;

import ttmy.framework.core.model.IModule;
import ttmy.framework.core.model.IRole;

public interface IRoleProvider {

	IRole loadRole(Long id);

	List<IModule> loadRoleModules(Long id);
}
