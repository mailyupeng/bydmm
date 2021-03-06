package ttmy.framework.secure;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ttmy.framework.context.UserContext;
import ttmy.framework.core.model.IModule;
import ttmy.framework.core.model.IRole;
import ttmy.framework.core.model.IUser;

public class AuthInterceptor implements HandlerInterceptor {

	private Set<String> uncheckedURLs;

	public void setUncheckedURLs(Set<String> uncheckedURLs) {
		this.uncheckedURLs = uncheckedURLs;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object arg2, ModelAndView mv)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		if (uncheckedURLs.contains(request.getServletPath()))
			return true;
		else if (UserContext.isLogin()) {
			IUser user = UserContext.getCurrentUser();
			if(user.getStatus() == IUser.ROOT)
				return true;
			IRole role = user.getCurrentRole();
			for (IModule module : role.getAuthModules()) {
				if (module.getUrl() != null && module.getUrl().equals(request.getServletPath()))
					return true;
			}
		}
		response.sendRedirect("loginPage.htm");
		return false;
	}
}
