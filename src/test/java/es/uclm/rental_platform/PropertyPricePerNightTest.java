package es.uclm.rental_platform;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import es.uclm.rental_platform.repository.PropertyRepository;

@SpringBootTest
@AutoConfigureMockMvc
class PropertyPricePerNightTest{
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PropertyRepository propertyRepository;

    @BeforeEach
    void clearProperties() {
        propertyRepository.deleteAll();
    }

    @Test
    void shouldAcceptPricePerNightWhenDataIsValid() throws Exception {

        String precio = "50.00";
    mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
                .param("description", "Casa junto al parque")
                .param("streetType", "Calle")
                .param("streetName", "Mayor")
                .param("number", "10")
                .param("postalCode", "45001")
                .param("city", "Toledo")
                .param("province", "Toledo")
                .param("pricePerNight", precio)
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/properties/new?created=true"));

        // Assert
        assertThat(propertyRepository.findAll())
                .singleElement()
                .satisfies(property -> {
                    assertThat(property.getPricePerNight()).isEqualTo(precio);
                });

    }

    void shouldAcceptPricePerNightWhenDataIsLimitValue() throws Exception {
    String precio = "0.01";
    mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
                .param("description", "Casa junto al parque")
                .param("streetType", "Calle")
                .param("streetName", "Mayor")
                .param("number", "10")
                .param("postalCode", "45001")
                .param("city", "Toledo")
                .param("province", "Toledo")
                .param("pricePerNight", precio)
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/properties/new?created=true"));

        // Assert
        assertThat(propertyRepository.findAll())
                .singleElement()
                .satisfies(property -> {
                    assertThat(property.getPricePerNight()).isEqualTo(precio);
                });

    }

     void shouldRejectPricePerNightWhenDataIsInvalid() throws Exception {
        String precio = "0.00";
    mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
                .param("description", "Casa junto al parque")
                .param("streetType", "Calle")
                .param("streetName", "Mayor")
                .param("number", "10")
                .param("postalCode", "45001")
                .param("city", "Toledo")
                .param("province", "Toledo")
                .param("pricePerNight", precio)
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
                .andExpect(status().isOk())
                .andExpect(view().name("property-form"))
                .andExpect(model().attributeHasFieldErrors("propertyForm","pricePerNight"));

        // Assert
        assertThat(propertyRepository.count()).isZero();

    }

}