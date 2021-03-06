package ttmy.framework.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

abstract public class KeyValueCache<K, V> implements ICache<K, V> {

	private int maxSize = 1000;
	private int writeOutTime = 60;
	private LoadingCache<K, V> cache;

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public void setWriteOutTime(int writeOutTime) {
		this.writeOutTime = writeOutTime;
	}

	{
		cache = CacheBuilder.newBuilder().maximumSize(maxSize).expireAfterWrite(writeOutTime, TimeUnit.SECONDS)
				.build(getCacheLoader());
	}

	public CacheLoader<K, V> getCacheLoader() {
		return new CacheLoader<K, V>() {
			public V load(K key) {
				return KeyValueCache.this.loadData(key);
			}
		};
	}

	abstract protected V loadData(K key);

	@Override
	final public V getData(K key) {
		try {
			return cache.get(key);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		KeyValueCache<String, String> c = new KeyValueCache<String, String>() {

			@Override
			protected String loadData(String key) {
				return "a";
			}
		};
		System.out.println(c.getData("aaa"));
	}
}
