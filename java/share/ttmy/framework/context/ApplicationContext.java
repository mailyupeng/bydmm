package ttmy.framework.context;

import ttmy.framework.util.SessionUtils;

public class ApplicationContext {

	public static String getAppName() {
		return SessionUtils.getServletContext().getServletContextName();
	}

}
