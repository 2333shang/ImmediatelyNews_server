package com.shang.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.shang.news.mapper")
@SpringBootApplication
public class ImmediatelyNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmediatelyNewsApplication.class, args);
	}
}
