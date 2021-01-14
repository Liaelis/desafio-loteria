package br.com.elis.loteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class LoteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoteriaApplication.class, args);
	}

}
