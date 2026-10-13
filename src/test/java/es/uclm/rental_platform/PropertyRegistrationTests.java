package es.uclm.rental_platform;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
    void validPropertyIsPersisted() throws Exception {
        mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
                .param("description", "Casa junto al parque")
                .param("address", "Calle Mayor 10, Toledo")
                .param("city", "Toledo")
                .param("pricePerNight", "85.50")
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/properties/new?created=true"));

        org.assertj.core.api.Assertions.assertThat(propertyRepository.count()).isEqualTo(1);
        var property = propertyRepository.findAll().get(0);
        org.assertj.core.api.Assertions.assertThat(property.getTitle()).isEqualTo("Casa rural");
        org.assertj.core.api.Assertions.assertThat(property.getAddress()).isEqualTo("Calle Mayor 10, Toledo");
        org.assertj.core.api.Assertions.assertThat(property.getCity()).isEqualTo("Toledo");
        org.assertj.core.api.Assertions.assertThat(property.isInstantBooking()).isTrue();
    }

    @Test
    void blankFieldsDoNotCreateProperty() throws Exception {
        mockMvc.perform(post("/properties"))
            .andExpect(status().isOk())
            .andExpect(view().name("property-form"))
            .andExpect(model().attributeHasFieldErrors(
                    "propertyForm", "title", "description", "address", "city", "pricePerNight", "amenities",
                    "type", "instantBooking"));

        org.assertj.core.api.Assertions.assertThat(propertyRepository.count()).isZero();
    }
}
