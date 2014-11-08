package ttmy.module.test.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class TestHts implements InitializingBean{
	
	@Resource(name="thessian")
	private ITs its;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(its.xx());
	}

}
