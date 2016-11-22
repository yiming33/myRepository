package me.mysql.service;

import me.mysql.entity.JPAlEntity;

/**
 * Created by YiMing on 2016/11/8. 服务接口
 */

public interface JPAService {

	public JPAlEntity findById(long id);

	public void deleteFromCache(long id);

}
