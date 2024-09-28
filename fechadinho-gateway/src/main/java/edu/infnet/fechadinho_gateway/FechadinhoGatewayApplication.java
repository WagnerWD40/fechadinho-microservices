package edu.infnet.fechadinho_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FechadinhoGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FechadinhoGatewayApplication.class, args);
	}

}
