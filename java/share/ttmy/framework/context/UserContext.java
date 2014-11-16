package ttmy.framework.context;

import ttmy.framework.cache.ICache;
import ttmy.framework.core.model.IUser;
import ttmy.framework.util.BeanUtils;
import ttmy.framework.util.SessionUtils;

public class UserContext {

	public static final String USER_ID_KEY = "__ttmy.framework.user.id__";
	public static final String ROLE_ID_KEY = "__ttmy.framework.role.id__";

	public static boolean isLogin() {
		Long userId = SessionUtils.getAttribute(USER_ID_KEY);
		return userId != null;
	}

	private static long getUserId() {
		return (Long) SessionUtils.getAttribute(USER_ID_KEY);
	}

	public static void setUserId(long userId) {
		SessionUtils.setAttribute(USER_ID_KEY, userId);
	}

	public static void setRoleId(long roleId) {
		SessionUtils.setAttribute(ROLE_ID_KEY, roleId);
	}

	public static long getRoleId() {
		return (Long) SessionUtils.getAttribute(ROLE_ID_KEY);
	}

	private static ICache<Long, IUser> getUserCache() {
		return BeanUtils.getBean("userCache");
	}

	public static IUser getCurrentUser() {
		return getUserCache().getData(getUserId());
	}
}
