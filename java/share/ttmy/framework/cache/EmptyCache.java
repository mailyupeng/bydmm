package ttmy.framework.cache;

import java.util.HashMap;
import java.util.Map;

public class EmptyCache<K, V> extends FullCache<K, V> {

	@Override
	public Map<K, V> loadDataFull() {
		return new HashMap<>();
	}

}
