package ttmy.framework.core.module;

import java.util.List;

public interface IRole {

	Long getId();

	String getName();
	
	List<IModule> getAuthModules() ;

}
