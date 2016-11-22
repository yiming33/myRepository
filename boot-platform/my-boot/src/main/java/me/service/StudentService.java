package me.service;

import me.entity.Student;

import java.util.List;

/**
 * Created by YiMing on 2016/11/11.
 */
public interface StudentService {

	List<Student> findAll();

	Student findOne(Long id);
}
