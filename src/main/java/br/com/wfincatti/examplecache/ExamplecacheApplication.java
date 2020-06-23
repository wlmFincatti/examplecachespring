package br.com.wfincatti.examplecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ExamplecacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamplecacheApplication.class, args);
	}

}
