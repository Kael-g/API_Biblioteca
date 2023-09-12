package com.catalisa.exercicioApiBiblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExercicioApiBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioApiBibliotecaApplication.class, args);
		/*System.out.println(new BCryptPasswordEncoder().encode("1234"));*/
	}
}
