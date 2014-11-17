package ttmy.module.frameworkimpl.service;

import ttmy.framework.base.service.IService;
import ttmy.module.frameworkimpl.model.Role;
import ttmy.module.frameworkimpl.model.User;

public interface IFrameService extends IService {

	User loadUser(String username);

	boolean hasRole(Long userId, Long roleId);

	Role getDefaultRole(Long userId);

}
