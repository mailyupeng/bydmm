package ttmy.module.frameworkimpl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ttmy.framework.base.service.BaseService;
import ttmy.module.frameworkimpl.dao.IUserDao;
import ttmy.module.frameworkimpl.model.Role;
import ttmy.module.frameworkimpl.model.User;

@Service("frameService")
public class FrameService extends BaseService implements IFrameService {

	@Resource(name = "userProvider")
	private IUserDao userDao;

	@Override
	public User loadUser(String username) {
		return userDao.loadByUsername(username);
	}

	@Override
	public boolean hasRole(Long userId, Long roleId) {
		return userDao.loadUserRole(userId, roleId) != null;
	}

	@Override
	public Role getDefaultRole(Long userId) {
		return userDao.loadUserDefaultRole(userId);
	}

}
