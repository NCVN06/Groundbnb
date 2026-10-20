package es.uclm.rental_platform.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.domain.PropertyType;
import es.uclm.rental_platform.repository.PropertyRepository;

/**
 * Carga propiedades de ejemplo cuando la base de datos está vacía.
 */
@Component
public class InitialPropertyDataLoader implements ApplicationRunner {

    private final PropertyRepository propertyRepository;

    public InitialPropertyDataLoader(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (propertyRepository.count() == 0) {
            propertyRepository.saveAll(List.of(
                    new Property("Casa junto al mar", "Terraza con vistas al Mediterráneo",
                            "Calle del Mar 12", "Alicante", new BigDecimal("120.00"), "Wi-Fi, terraza",
                            PropertyType.HOME, true),
                    new Property("Piso en el centro", "Apartamento luminoso cerca de los museos",
                            "Calle Mayor 8", "Madrid", new BigDecimal("95.00"), "Wi-Fi, ascensor",
                            PropertyType.HOME, false),
                    new Property("Cabaña en la montaña", "Alojamiento tranquilo rodeado de naturaleza",
                            "Camino del Bosque 3", "Cuenca", new BigDecimal("80.00"), "Chimenea, jardín",
                            PropertyType.HOME, true),
                    new Property("Casa de campo con jardín", "Vivienda rural con un amplio jardín",
                            "Avenida de la Estación 21", "Valencia", new BigDecimal("110.00"), "Wi-Fi, jardín",
                            PropertyType.HOME, false),
                    new Property("Estudio junto al río", "Estudio acogedor con cocina equipada",
                            "Paseo del Río 5", "Toledo", new BigDecimal("68.00"), "Cocina, Wi-Fi",
                            PropertyType.HOME, true)));
        }
    }
}
