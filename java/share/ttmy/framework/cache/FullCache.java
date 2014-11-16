package ttmy.framework.cache;

import java.util.Map;

abstract public class FullCache<K, V> extends KeyValueCache<Integer, Map<K, V>> {

	@Override
	protected Map<K, V> loadData(Integer key) {
		return loadDataFull();
	}

	abstract protected Map<K, V> loadDataFull();
}
