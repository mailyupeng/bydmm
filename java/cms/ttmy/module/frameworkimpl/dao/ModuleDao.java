package ttmy.module.frameworkimpl.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ttmy.framework.base.dao.BaseEntityDao;
import ttmy.framework.core.dao.IModuleProvider;
import ttmy.framework.core.model.IModule;
import ttmy.module.frameworkimpl.model.Module;

@Repository("moduleProvider")
public class ModuleDao extends BaseEntityDao<Module> implements IModuleDao, IModuleProvider {

	@Override
	public List<IModule> loadAll() {
		return new ArrayList<>(super.findAll());
	}

	@Override
	public List<IModule> findByIds(Collection<Long> ids) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Module.class);
		detachedCriteria.add(Restrictions.in("id", ids));
		return new ArrayList<>(super.findBy(detachedCriteria));
	}
}
