package org.naranpoba.kkoritag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class KkoritagApplication {

	public static void main(String[] args) {
		SpringApplication.run(KkoritagApplication.class, args);
		log.debug("Hello Lombok Logs!");
	}

}
