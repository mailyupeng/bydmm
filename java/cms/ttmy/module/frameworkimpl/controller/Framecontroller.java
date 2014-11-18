package ttmy.module.frameworkimpl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ttmy.framework.base.controller.BaseController;
import ttmy.framework.context.UserContext;
import ttmy.framework.util.EncryptUtils;
import ttmy.module.frameworkimpl.model.Role;
import ttmy.module.frameworkimpl.model.User;
import ttmy.module.frameworkimpl.service.IFrameService;

@Controller
public class Framecontroller extends BaseController {

	@RequestMapping("loginPage.htm")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("login.htm")
	public @ResponseBody Map<String, String> login(String username, String password, Long roleId,
			HttpServletResponse response) {
		if (username != null && password != null) {
			User user = frameService.loadUser(username);
			if (user != null) {
				if (EncryptUtils.md5Encoder(username + password).equals(user.getPassword())) {
					if (roleId == null) {
						Role role = frameService.getDefaultRole(user.getId());
						if (role != null)
							roleId = role.getId();
					} else if (frameService.hasRole(user.getId(), roleId)) {

					}
					if (roleId != null) {
						UserContext.setRoleId(roleId);
						UserContext.setUserId(user.getId());

						Map<String, String> m = new HashMap<>();
						m.put("msg", "登录成功");
						return m;
					}
				}
			}
		}
		Map<String, String> m = new HashMap<>();
		m.put("msg", "登录失败");
		return m;
	}

	@Resource(name = "frameService")
	private IFrameService frameService;
}
