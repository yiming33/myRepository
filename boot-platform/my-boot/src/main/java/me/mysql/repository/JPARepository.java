package me.mysql.repository;

import me.mysql.entity.JPAlEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by YiMing on 2016/11/8.
 */
public interface JPARepository extends CrudRepository<JPAlEntity, Long> {
}
