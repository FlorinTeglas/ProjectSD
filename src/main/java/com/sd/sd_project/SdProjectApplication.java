package com.sd.sd_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sd.sd_project.repository")
@SpringBootApplication
public class SdProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdProjectApplication.class, args);
	}

}

