package me.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by YiMing on 2016/11/7.
 */
@ConfigurationProperties(prefix = "yiming",locations = "classpath:config/myproperties.properties")
public class YiMingConfig {
    private String name;
    private int age;

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
