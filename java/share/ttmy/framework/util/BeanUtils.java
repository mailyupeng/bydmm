package ttmy.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements BeanFactoryAware {

	private static BeanFactory beanFactory;

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanId) {
		return (T) beanFactory.getBean(beanId);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		beanFactory = arg0;
	}

}
