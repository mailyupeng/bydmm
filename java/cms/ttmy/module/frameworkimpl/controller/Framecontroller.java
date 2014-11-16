package ttmy.module.frameworkimpl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ttmy.framework.context.UserContext;

@Controller
public class Framecontroller {

	@RequestMapping("loginPage.htm")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("login.htm")
	public @ResponseBody Map<String, String> login(String username, String password) {
		UserContext.setRoleId(1);
		UserContext.setUserId(1);
		Map<String, String> m = new HashMap<>();
		m.put("msg", "成功");
		return m;
	}

}
