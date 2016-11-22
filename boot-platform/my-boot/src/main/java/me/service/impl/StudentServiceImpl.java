package me.service.impl;

import me.entity.Student;
import me.repository.StudentRepository;
import me.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YiMing on 2016/11/11.
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
    @Cacheable(value = "students")
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
    @Cacheable(value = "student",key = "#id + 10")
	public Student findOne(Long id) {
		return studentRepository.findOne(id);
	}
}
