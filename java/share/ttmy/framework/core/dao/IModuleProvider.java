package ttmy.framework.core.dao;

import java.util.List;

import ttmy.framework.core.module.IModule;

public interface IModuleProvider {
	
	List<IModule> loadAll();

}
