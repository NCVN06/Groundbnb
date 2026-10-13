package es.uclm.rental_platform.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal pricePerNight;

    @Column(nullable = false)
    private String amenities;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyType type;

    @Column(nullable = false)
    private boolean instantBooking;

    protected Property() {
    }

    public Property(String title, String description, String address, String city, BigDecimal pricePerNight,
            String amenities, PropertyType type, boolean instantBooking) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.city = city;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        this.type = type;
        this.instantBooking = instantBooking;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public PropertyType getType() {
        return type;
    }

    public boolean isInstantBooking() {
        return instantBooking;
    }
}
