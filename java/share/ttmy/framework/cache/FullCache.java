package ttmy.framework.cache;

import java.util.Map;

abstract public class FullCache<K, V> extends KeyValueCache<Integer, Map<K, V>> {

	@Override
	public Map<K, V> loadData(Integer key) {
		return loadDataFull();
	}

	abstract public Map<K, V> loadDataFull();
}
