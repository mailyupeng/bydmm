package ttmy.framework.core.model;

import java.util.List;

public interface IModule {

	int SYS = 0; // 系统
	int MENU = 1; // 菜单
	int WIGIT = 2; // 页面控件

	Long getId();

	default Long getParentId() {
		return null;
	};

	String getName();

	String getUrl();

	default int getType() {
		return 1;
	};

	default List<IModule> children() {
		return null;
	}

	default int getSort() {
		return 0;
	};

}
