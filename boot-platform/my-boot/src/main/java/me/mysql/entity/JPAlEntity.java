package me.mysql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by YiMing on 2016/11/8.
 */
@Entity
public class JPAlEntity implements Serializable {
	private static final long serialVersionUID = -49057528883302325L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
