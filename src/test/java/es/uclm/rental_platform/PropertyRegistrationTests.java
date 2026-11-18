package es.uclm.rental_platform;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
class PropertyRegistrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PropertyRepository propertyRepository;

    @BeforeEach
    void clearProperties() {
        propertyRepository.deleteAll();
    }

    @Test
    void shouldCreatePropertyWhenDataIsValid() throws Exception {
        // Arrange
        String title = "Casa rural";
        String address = "Calle Mayor, s/n, C.P. 45001, Toledo";

        // Act
        mockMvc.perform(post("/properties")
                .param("title", title)
                .param("description", "Casa junto al parque")
                .param("streetType", "Calle")
                .param("streetName", "Mayor")
                .param("number", "s/n")
                .param("postalCode", "45001")
                .param("city", "Toledo")
                .param("province", "Toledo")
                .param("pricePerNight", "85.50")
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/properties/new?created=true"));

        // Assert
        assertThat(propertyRepository.findAll())
                .singleElement()
                .satisfies(property -> {
                    assertThat(property.getTitle()).isEqualTo(title);
                    assertThat(property.getAddress()).isEqualTo(address);
                    assertThat(property.getCity()).isEqualTo("Toledo");
                    assertThat(property.isInstantBooking()).isTrue();
                });
    }

    @Test
    void shouldRejectPropertyWhenDataIsInvalid() throws Exception {
        // Arrange
        long propertyCountBeforeRequest = propertyRepository.count();

        // Act
        mockMvc.perform(post("/properties"))
            .andExpect(status().isOk())
            .andExpect(view().name("property-form"))
            .andExpect(model().attributeHasFieldErrors(
                    "propertyForm", "title", "description", "city", "pricePerNight", "amenities",
                    "type", "instantBooking"));

        // Assert
        assertThat(propertyRepository.count()).isEqualTo(propertyCountBeforeRequest);
    }
}
