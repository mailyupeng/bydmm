package ttmy.framework.core.model;

import java.util.List;

public interface IRole {

	Long getId();

	String getName();

	default List<IModule> getAuthModules() {
		return null;
	}

}
