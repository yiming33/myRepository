package me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2016/11/12.
 */
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		System.out.println("into app...");
		SpringApplication.run(Main.class, args);
	}
}
