package ttmy.framework.base.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ttmy.framework.context.UserContext;
import ttmy.framework.core.model.IUser;

public class BaseService implements IService {

	protected Log log = LogFactory.getLog(this.getClass());

	protected IUser currentUser() {
		return UserContext.getCurrentUser();
	}

}
