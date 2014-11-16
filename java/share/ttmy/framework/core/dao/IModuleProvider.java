package ttmy.framework.core.dao;

import java.util.List;

import ttmy.framework.core.model.IModule;

public interface IModuleProvider {
	
	List<IModule> loadAll();

}
