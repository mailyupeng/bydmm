package ttmy.framework.cache;

public interface ICache<K, V> {
	V getData(K key);
}
