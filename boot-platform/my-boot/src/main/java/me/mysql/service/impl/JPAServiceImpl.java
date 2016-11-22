package me.mysql.service.impl;

import me.mysql.entity.JPAlEntity;
import me.mysql.repository.JPARepository;
import me.mysql.service.JPAService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by YiMing on 2016/11/8.
 */
@Service
public class JPAServiceImpl implements JPAService {

	@Resource
	private JPARepository redisRepository;

	// @Resource
	// private RedisTemplate<String, String> redisTemplate;

	@Cacheable(key = "#id", value = "test") // 缓存,这里没有指定key.
	@Override
	public JPAlEntity findById(long id) {
		return redisRepository.findOne(id);
	}

	// @Cacheable(value = "redisEntity")
	@Override
	public void deleteFromCache(long id) {
		redisRepository.delete(id);
	}

}
