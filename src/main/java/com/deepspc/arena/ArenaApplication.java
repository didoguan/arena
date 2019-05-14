package com.deepspc.arena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ArenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArenaApplication.class, args);
	}

}
