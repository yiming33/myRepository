package me.redis.service.impl;

import me.redis.service.RedisCacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by YiMing on 2016/11/9.
 */
@Service
public class RedisCacheServiceImpl<K, V> implements RedisCacheService<K, V> {

	@Resource
	private RedisTemplate<K, V> redisTemplate;

	@Override
	public <E extends V> void save(K key, E obj) {
		redisTemplate.opsForValue().set(key, obj);
	}

	@Override
	public V findOne(K key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void delete(K key) {
		redisTemplate.delete(key);
	}

	@Override
	public void deleteAll() {
		// redisTemplate.
	}

	@Override
	public long count() {
		return 0;
	}
}
