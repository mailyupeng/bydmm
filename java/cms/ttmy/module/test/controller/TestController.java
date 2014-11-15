package ttmy.module.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ttmy.framework.context.ApplicationContext;
import ttmy.module.test.service.AbcService;

@Controller
public class TestController {

	@Resource(name="abcService")
	private AbcService as;
	
	@RequestMapping("test.htm")
	public ModelAndView test( String x) {
		as.xxx();
		return new ModelAndView("tj", "s", ApplicationContext.getAppName());
	}
	
}
