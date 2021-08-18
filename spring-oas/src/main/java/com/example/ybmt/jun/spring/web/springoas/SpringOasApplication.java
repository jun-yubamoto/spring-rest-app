package com.example.ybmt.jun.spring.web.springoas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ybmt.jun.orm.mbg.mapper.sample")
public class SpringOasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOasApplication.class, args);
	}

}
