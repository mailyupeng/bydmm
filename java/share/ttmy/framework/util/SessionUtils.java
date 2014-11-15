package ttmy.framework.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(String key) {
		return (T) getHttpSession().getAttribute(key);
	}

	public static void setAttribute(String key, Object value) {
		getHttpSession().setAttribute(key, value);
	}

	public static ServletRequestAttributes getServletRequestAttributes() {
		return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	}

	public static HttpSession getHttpSession() {
		return getServletRequestAttributes().getRequest().getSession();
	}

	public static ServletContext getServletContext() {
		return getHttpSession().getServletContext();
	}

}
