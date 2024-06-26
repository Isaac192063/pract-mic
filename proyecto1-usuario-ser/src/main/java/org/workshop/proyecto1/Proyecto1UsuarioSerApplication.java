package org.workshop.proyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class Proyecto1UsuarioSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1UsuarioSerApplication.class, args);
	}

}
