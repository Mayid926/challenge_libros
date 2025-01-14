package com.aluracursos.desafio;

import com.aluracursos.desafio.principal.Principal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DesafioApplicationTests implements CommandLineRunner {

public static void main(String[] args) {
	SpringApplication.run(DesafioApplicationTests.class, args);
}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
