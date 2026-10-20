/* 
package es.uclm.rental_platform;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.uclm.rental_platform.domain.PropertyType;
import es.uclm.rental_platform.repository.PropertyRepository;

    //
    //* Comprueba que el catálogo de ejemplo se carga al iniciar la aplicación.
    //
@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:property-initialization-${random.uuid}")
class InitialPropertyDataLoaderTests {

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    void loadsAtLeastFivePropertiesOnStartup() {
        long homes = propertyRepository.findAll().stream()
                .filter(property -> property.getType() == PropertyType.HOME)
                .count();
        assertTrue(homes >= 5);
    }
    
}
*/