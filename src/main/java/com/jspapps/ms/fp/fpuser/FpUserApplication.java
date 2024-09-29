package com.jspapps.ms.fp.fpuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FpUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FpUserApplication.class, args);
	}

}
