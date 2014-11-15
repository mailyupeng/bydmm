package ttmy.module.frameworkimpl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Framecontroller {

	@RequestMapping("loginPage.htm")
	public String toLogin() {
		return "login";
	}

}
