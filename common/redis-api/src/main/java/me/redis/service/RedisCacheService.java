package me.redis.service;

/**
 * Created by YiMing on 2016/11/9.
 */
public interface RedisCacheService<K, V> {

	<E extends V> void save(K key, E obj);

	V findOne(K key);

	void delete(K key);

	void deleteAll();

	long count();
}
