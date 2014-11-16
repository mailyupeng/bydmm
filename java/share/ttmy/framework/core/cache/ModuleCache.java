package ttmy.framework.core.cache;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ttmy.framework.cache.FullCache;
import ttmy.framework.core.dao.IModuleProvider;
import ttmy.framework.core.model.IModule;
import ttmy.framework.util.BeanUtils;

@Component("moduleCache")
public class ModuleCache extends FullCache<Long, IModule> {

	@Override
	protected Map<Long, IModule> loadDataFull() {
		IModuleProvider provider = BeanUtils.getBean("moduleProvider");
		Map<Long, IModule> map = new HashMap<>();
		for (IModule module : provider.loadAll()) {
			IModule m = new IModule() {

				@Override
				public Long getId() {
					return module.getId();
				}

				@Override
				public Long getParentId() {
					return module.getParentId();
				}

				@Override
				public String getName() {
					return module.getName();
				}

				@Override
				public String getUrl() {
					return module.getUrl();
				}

				@Override
				public int getType() {
					return module.getType();
				}

				private List<IModule> children = new ArrayList<>();

				@Override
				public List<IModule> children() {
					return children;
				}

				@Override
				public int getSort() {
					return module.getSort();
				}
			};
			map.put(module.getId(), m);
		}
		for (IModule m : map.values()) {
			if (m.getParentId() != null) {
				map.get(m.getParentId()).children().add(m);
			}
		}
		for (IModule m : map.values()) {
			m.children().sort(new Comparator<IModule>() {
				public int compare(IModule o1, IModule o2) {
					return o1.getSort() - o2.getSort();
				}
			});
		}
		return map;
	}

}
