package ttmy.module.frameworkimpl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import ttmy.framework.base.dao.BaseEntityDao;
import ttmy.framework.core.dao.IRoleProvider;
import ttmy.framework.core.model.IModule;
import ttmy.framework.core.model.IRole;
import ttmy.module.frameworkimpl.model.Role;
import ttmy.module.frameworkimpl.model.RoleModule;

@Repository("roleProvider")
public class RoleDao extends BaseEntityDao<Role> implements IRoleDao, IRoleProvider {

	@Resource(name = "moduleProvider")
	private IModuleDao moduleProvider;

	@Override
	public IRole loadRole(Long id) {
		return super.findById(id);
	}

	@Override
	public List<IModule> loadRoleModules(Long id) {
		List<RoleModule> rml = super.getHibernateTemplate().execute(new HibernateCallback<List<RoleModule>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<RoleModule> doInHibernate(Session session) throws HibernateException {
				return session.createCriteria(RoleModule.class).add(Restrictions.eq("roleId", id)).list();
			}
		});
		return new ArrayList<>(moduleProvider.findByIds(rml.stream().map(rm -> rm.getModuleId())
				.collect(Collectors.toList())));
	}

}
