package es.uclm.rental_platform.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.domain.PropertyType;
import es.uclm.rental_platform.repository.PropertyRepository;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public Property createProperty(String title, String description, String address, String city,
            BigDecimal pricePerNight, String amenities, PropertyType type, boolean instantBooking) {
        Property property = new Property(title, description, address, city, pricePerNight, amenities, type,
                instantBooking);
        return propertyRepository.save(property);
    }
}