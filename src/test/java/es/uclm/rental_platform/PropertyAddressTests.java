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
class PropertyAddressTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PropertyRepository propertyRepository;

    @BeforeEach
    void clearProperties() {
        propertyRepository.deleteAll();
    }

    @Test
    void formShowsSeparateAddressFieldsAndStreetTypeDropdown() throws Exception {
        mockMvc.perform(get("/properties/new"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Tipo de vía")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Calle o nombre de la vía")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("maxlength=\"20\"")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Travesía")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Portal / Escalera (opcional)")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Piso o planta (opcional)")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Puerta / Letra (opcional)")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("pattern=\"[0-9]{5}\"")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Ciudad / Municipio")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString(
                        "<select id=\"city\" autocomplete=\"address-level2\" required disabled name=\"city\">")))
                .andExpect(content().string(org.hamcrest.Matchers.not(
                        org.hamcrest.Matchers.containsString("Selecciona una provincia para ver sugerencias"))))
                .andExpect(content().string(org.hamcrest.Matchers.not(
                        org.hamcrest.Matchers.containsString("municipalityOptions"))))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("id=\"postalCode\"")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("id=\"postalCodeOptions\"")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("municipalityCatalogUrl")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Código postal")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Alicante/Alacant")));
    }

    @Test
    void localMunicipalityCatalogIsServed() throws Exception {
        mockMvc.perform(get("/data/municipalities.json"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("\"Toledo\"")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("\"postalCodes\":[")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("\"name\":\"Ajofrín\"")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Ciudad Autónoma de Melilla")));
    }

    @Test
    void validDetailedAddressIsFormattedAndPersisted() throws Exception {
        mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
                .param("description", "Casa junto al parque")
                .param("streetType", "Travesía")
                .param("streetName", "Mayor")
                .param("number", "10")
                .param("portal", "2")
                .param("floor", "3")
                .param("door", "A")
                .param("postalCode", "45001")
                .param("city", "Toledo")
                .param("province", "Toledo")
                .param("pricePerNight", "85.50")
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/properties/new?created=true"));

        assertThat(propertyRepository.count()).isEqualTo(1);
        var property = propertyRepository.findAll().get(0);
        assertThat(property.getAddress())
                .isEqualTo("Travesía Mayor, 10, portal 2, piso 3, puerta A, C.P. 45001, Toledo");
        assertThat(property.getCity()).isEqualTo("Toledo");
    }

    @Test
    void requiredAddressComponentsAreValidatedBeforePersisting() throws Exception {
        mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
                .param("description", "Casa junto al parque")
                .param("streetType", "Calle")
                .param("streetName", "")
                .param("number", "10")
                .param("postalCode", "45001")
                .param("city", "Toledo")
                .param("province", "Toledo")
                .param("pricePerNight", "85.50")
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
                .andExpect(status().isOk())
                .andExpect(view().name("property-form"))
                .andExpect(model().attributeHasFieldErrors("propertyForm", "streetName"));

        assertThat(propertyRepository.count()).isZero();
    }

    @Test
    void optionalAddressComponentsCanBeOmitted() throws Exception {
        mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
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
                .param("instantBooking", "false"))
                .andExpect(status().is3xxRedirection());

        assertThat(propertyRepository.findAll().get(0).getAddress())
                .isEqualTo("Calle Mayor, s/n, C.P. 45001, Toledo");
    }

    @Test
    void postalCodeMustContainExactlyFiveDigits() throws Exception {
        mockMvc.perform(post("/properties")
                .param("title", "Casa rural")
                .param("description", "Casa junto al parque")
                .param("streetType", "Calle")
                .param("streetName", "Mayor")
                .param("number", "10")
                .param("postalCode", "4500A")
                .param("city", "Toledo")
                .param("province", "Toledo")
                .param("pricePerNight", "85.50")
                .param("amenities", "Wi-Fi, cocina")
                .param("type", "HOME")
                .param("instantBooking", "true"))
                .andExpect(status().isOk())
                .andExpect(view().name("property-form"))
                .andExpect(model().attributeHasFieldErrors("propertyForm", "postalCode"));

        assertThat(propertyRepository.count()).isZero();
    }
}
