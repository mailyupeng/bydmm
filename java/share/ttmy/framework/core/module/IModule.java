package ttmy.framework.core.module;

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
	
	List<IModule> children();

}
