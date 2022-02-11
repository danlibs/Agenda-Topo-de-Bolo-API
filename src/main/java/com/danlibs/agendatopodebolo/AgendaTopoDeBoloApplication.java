package com.danlibs.agendatopodebolo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@ComponentScan("com.danlibs.agendatopodebolo")
public class AgendaTopoDeBoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaTopoDeBoloApplication.class, args);
	}

}
