package es.uclm.rental_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicación de alquileres basada en Spring Boot.
 */
@SpringBootApplication
public class RentalPlatformApplication {

	/**
	 * Inicia el contexto de la aplicación Spring.
	 *
	 * @param args argumentos de línea de comandos recibidos por la aplicación
	 */
	public static void main(String[] args) {
		SpringApplication.run(RentalPlatformApplication.class, args);
	}

}
