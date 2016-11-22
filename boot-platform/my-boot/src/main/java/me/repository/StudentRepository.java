package me.repository;

import me.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by YiMing on 2016/11/11.
 */
public interface StudentRepository {

	List<Student> findAll();

	@Select("select * from student where id = #{id}")
	Student findOne(Long id);
}
