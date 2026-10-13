package es.uclm.rental_platform.web;

import java.math.BigDecimal;

import es.uclm.rental_platform.domain.PropertyType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PropertyForm {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotNull
    @DecimalMin("0.01")
    @Digits(integer = 17, fraction = 2)
    private BigDecimal pricePerNight;

    @NotBlank
    private String amenities;

    @NotNull
    private PropertyType type;

    @NotNull
    private Boolean instantBooking;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public Boolean getInstantBooking() {
        return instantBooking;
    }

    public void setInstantBooking(Boolean instantBooking) {
        this.instantBooking = instantBooking;
    }
}
