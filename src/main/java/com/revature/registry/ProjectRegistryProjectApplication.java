package com.revature.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ProjectRegistryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectRegistryProjectApplication.class, args);
	}

}
