package ttmy.framework.deploy;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryAutowiring implements BeanPostProcessor {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (((bean instanceof HibernateDaoSupport)) && (((HibernateDaoSupport) bean).getSessionFactory() == null)) {
			((HibernateDaoSupport) bean).setSessionFactory(this.sessionFactory);
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}