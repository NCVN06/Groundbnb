/*
package es.uclm.rental_platform;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;


 //Pruebas de integración que verifican la inicialización de Spring y la
 //navegación disponible en la página de registro.

@SpringBootTest
@AutoConfigureMockMvc
class RentalPlatformApplicationTests {

	// Contexto de Spring creado para la aplicación durante la prueba.
	@Autowired
	private ApplicationContext applicationContext;

	// Cliente MVC para realizar solicitudes HTTP de prueba sin iniciar un servidor.
	@Autowired
	private MockMvc mockMvc;

	
	//Verifica que el contexto de Spring se ha inicializado y contiene la aplicación.
	 
	@Test
	void contextLoads() {
		assertNotNull(applicationContext.getBean(RentalPlatformApplication.class));
	}

	
	 //Verifica que la página de registro ofrece un enlace para volver a la página
	 //principal.
	 
	 //@throws Exception si falla la solicitud MVC de prueba
	 
	@Test
	void propertyRegistrationPageLinksBackToHome() throws Exception {
		mockMvc.perform(get("/properties/new"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("href=\"/\"")))
				.andExpect(content().string(containsString("Volver al inicio")));
	}

}
*/