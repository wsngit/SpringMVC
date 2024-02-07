package ru.vlsu.ispi.kpp.SpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringMvcApplication {

	@Bean("singletonService")
	@Scope("singleton")
	RandomService singletonService() {
		return new RandomService() ;
	}

	@Bean("requestService")
	@Scope("request")
	RandomService requestService() {
		return new RandomService() ;
	}

	@Bean("sessionService")
	@Scope("session")
	RandomService sessionService() {
		return new RandomService() ;
	}

/*
request
session
application
websocket
*/

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
