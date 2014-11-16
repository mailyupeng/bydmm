package ttmy.framework.core.model;

import java.util.List;

public interface IModule {

	int SYS = 0; // 系统
	int MENU = 1; // 菜单
	int WIGIT = 2; // 页面控件

	Long getId();

	Long getParentId();

	String getName();

	String getUrl();

	int getType();

	default List<IModule> children() {
		return null;
	}

	int getSort();

}
