package es.uclm.rental_platform;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.domain.PropertyType;
import es.uclm.rental_platform.repository.PropertyRepository;

/**
 * Pruebas de integración para la consulta del catálogo de propiedades.
 */
@SpringBootTest
@AutoConfigureMockMvc
class PropertySearchTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PropertyRepository propertyRepository;

    @BeforeEach
    void clearProperties() {
        propertyRepository.deleteAll();
    }

    @Test
    void initialPageShowsAllProperties() throws Exception {
        propertyRepository.save(property("Casa del lago", "Vistas al agua", "Calle Norte 1", "Cuenca"));
        propertyRepository.save(property("Piso céntrico", "Cerca del centro", "Calle Sur 2", "Toledo"));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Casa del lago")))
                .andExpect(content().string(containsString("Piso céntrico")));
    }

    @Test
    void emptyQueryShowsValidationMessage() throws Exception {
        propertyRepository.save(property("Casa del lago", "Vistas al agua", "Calle Norte 1", "Cuenca"));

        mockMvc.perform(get("/").param("query", ""))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("No has introducido una búsqueda.")))
                .andExpect(content().string(not(containsString("Casa del lago"))));
    }

    @Test
    void queryFindsMatchesIgnoringCase() throws Exception {
        propertyRepository.save(property("Casa junto al mar", "Terraza amplia", "Calle Azul 4", "Alicante"));
        propertyRepository.save(property("Piso céntrico", "Cerca del centro", "Calle Sur 2", "Toledo"));

        mockMvc.perform(get("/").param("query", "ALICANTE"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Casa junto al mar")))
                .andExpect(content().string(not(containsString("Piso céntrico"))));
    }

    @Test
    void queryWithoutMatchesShowsInformativeMessage() throws Exception {
        propertyRepository.save(property("Casa del lago", "Vistas al agua", "Calle Norte 1", "Cuenca"));

        mockMvc.perform(get("/").param("query", "inexistente"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "No se ha encontrado ninguna propiedad que coincida con la búsqueda.")));
    }

    private Property property(String title, String description, String address, String city) {
        return new Property(title, description, address, city, new BigDecimal("95.00"), "Wi-Fi",
                PropertyType.HOME, false);
    }
}
