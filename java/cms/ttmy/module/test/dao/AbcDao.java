package ttmy.module.test.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ttmy.module.test.domain.Abc;

@Repository("abcDao")
public class AbcDao extends HibernateDaoSupport {

	public void aaa() {
		System.out.println(super.getHibernateTemplate().find("from " + Abc.class.getName()));
	}

}
