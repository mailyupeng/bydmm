package ttmy.framework.core.model;

import java.util.ArrayList;
import java.util.List;

public interface IRole {

	Long getId();

	String getName();

	default List<IModule> getAuthModules() {
		return new ArrayList<IModule>();
	}

}
