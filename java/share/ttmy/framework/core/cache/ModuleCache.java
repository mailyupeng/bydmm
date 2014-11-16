package ttmy.framework.core.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import ttmy.framework.cache.FullCache;
import ttmy.framework.core.dao.IModuleProvider;
import ttmy.framework.core.module.IModule;
import ttmy.framework.util.BeanUtils;

@Component("moduleCache")
public class ModuleCache extends FullCache<Long, IModule> {

	@Override
	protected Map<Long, IModule> loadDataFull() {
		IModuleProvider provider = BeanUtils.getBean("moduleProvider");
		Map<Long, IModule> map = new HashMap<>();
		for(IModule module: provider.loadAll()) {
			map.put(module.getId(), module);
		}
		return map;
	}

}
