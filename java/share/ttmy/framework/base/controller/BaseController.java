package ttmy.framework.base.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ttmy.framework.context.UserContext;
import ttmy.framework.core.model.IUser;

public class BaseController {

	protected Log log = LogFactory.getLog(this.getClass());

	protected IUser currentUser() {
		return UserContext.getCurrentUser();
	}

}
