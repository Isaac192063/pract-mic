package org.workshop.proyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Proyecto1UsuarioSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1UsuarioSerApplication.class, args);
	}

}
