package me.controller;

import com.github.pagehelper.PageHelper;
import me.config.ServerConfig;
import me.config.YiMingConfig;
import me.entity.Student;
import me.mysql.entity.JPAlEntity;
import me.mysql.service.JPAService;
import me.redis.service.RedisCacheService;
import me.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by YiMing on 2016/10/28.
 */
@RestController
@RequestMapping("/")
public class BootRestController {

	@Autowired
	private ServerConfig serverConfig;

	@Autowired
	private YiMingConfig yiMingConfig;

	@Autowired
	private JPAService jpaService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private StudentService studentService;

	@RequestMapping("/")
	public String hello() {
		return "hello world";
	}

	/**
	 * 读取资源文件
	 * 
	 * @return
	 */
	@RequestMapping("/getProperties")
	public String getProperties() {
		System.out.println(serverConfig.getPort());
		System.out.println(yiMingConfig.getName());
		System.out.println(yiMingConfig.getAge());
		return serverConfig.getContextPath();

	}

	@RequestMapping("/student")
	public Student student() {
		Student student = new Student();
		student.setId(1l);
		student.setName("易明");
		student.setAge(22);
		return student;
	}

	@RequestMapping("/findAll")
	public List<Student> findAll(int page) {
		PageHelper.startPage(page, 1);
		List<Student> students = studentService.findAll();
		Student student = studentService.findOne(1l);
		return students;
	}

	/**
	 * 从mysql中获取数据（先检查缓存中是否存在）
	 * 
	 * @return
	 */
	@RequestMapping("/findById")
	public JPAlEntity findById(Long id) {
		return jpaService.findById(id);
	}

	/**
	 * 测试redis缓存
	 *
	 * @return
	 */
	@RequestMapping("/redisTest")
	public void redisTest() {
		JPAlEntity jpAlEntity = new JPAlEntity();
		jpAlEntity.setId(1l);
		jpAlEntity.setAge(22);
		jpAlEntity.setName("易明");
		redisCacheService.save("yyy", jpAlEntity);
		redisCacheService.save("eee", "aaa");
		JPAlEntity g = (JPAlEntity) redisCacheService.findOne("yyy");
		redisCacheService.delete("yyy");
	}

	public String thymeleafTest(Map<String, Object> map) {
		return "/helloHtml";
	}
}
