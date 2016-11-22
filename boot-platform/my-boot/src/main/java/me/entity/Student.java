package me.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by YiMing on 2016/10/31.
 */
@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 2503680716941558703L;
	@Id
	@GeneratedValue
	private Long id;

	@JSONField(serialize = false)
	private String name;

	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
