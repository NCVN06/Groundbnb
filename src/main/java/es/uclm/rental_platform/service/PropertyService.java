package es.uclm.rental_platform.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.domain.PropertyType;
import es.uclm.rental_platform.repository.PropertyRepository;

/**
 * Proporciona operaciones de negocio para registrar propiedades de alquiler.
 */
@Service
public class PropertyService {

    /** Repositorio utilizado para persistir las entidades de propiedad. */
    private final PropertyRepository propertyRepository;

    /**
     * Crea el servicio con su dependencia de persistencia.
     *
     * @param propertyRepository repositorio utilizado para almacenar propiedades
     */
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    /**
     * Crea una propiedad con los datos proporcionados y la almacena.
     *
     * @param title título visible de la propiedad
     * @param description descripción de la propiedad
     * @param address dirección de la propiedad
     * @param city ciudad donde se encuentra la propiedad
     * @param pricePerNight precio por noche
     * @param amenities descripción de las comodidades de la propiedad
     * @param type tipo de propiedad
     * @param instantBooking indica si los huéspedes pueden reservar la propiedad
     *        de forma inmediata
     * @return la propiedad guardada, incluidos los valores generados durante la
     *         persistencia
     * @throws org.springframework.dao.DataAccessException si el repositorio no
     *         puede persistir la propiedad
     */
    @Transactional
    public Property createProperty(String title, String description, String address, String city,
            BigDecimal pricePerNight, String amenities, PropertyType type, boolean instantBooking) {
        Property property = new Property(title, description, address, city, pricePerNight, amenities, type,
                instantBooking);
        return propertyRepository.save(property);
    }

    /**
     * Busca propiedades por texto en sus datos descriptivos y de ubicación.
     *
     * @param query texto libre que se buscará en título, descripción, dirección y
     *        ciudad; si está vacío o contiene solo espacios, devuelve todas las
     *        propiedades
     * @return propiedades que coinciden con la consulta, o todas si está vacía
     */
    @Transactional(readOnly = true)
    public List<Property> searchProperties(String query) {
        if (query == null || query.isBlank()) {
            return propertyRepository.findAll();
        }

        String searchTerm = query.trim();
        return propertyRepository.searchByText(searchTerm);
    }
}