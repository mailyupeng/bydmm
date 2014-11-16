package ttmy.module.frameworkimpl.dao;

import java.util.Collection;
import java.util.List;

import ttmy.framework.base.dao.IEntityDao;
import ttmy.framework.core.model.IModule;
import ttmy.module.frameworkimpl.model.Module;

public interface IModuleDao extends IEntityDao<Module> {
	
	List<IModule> findByIds(Collection<Long> ids);

}
