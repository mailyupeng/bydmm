package ttmy.module.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ttmy.module.test.dao.AbcDao;

@Service("abcService")
public class AbcService {

	@Resource(name = "abcDao")
	private AbcDao abcDao;
	
	public void xxx() {
		abcDao.aaa();
	}

}
