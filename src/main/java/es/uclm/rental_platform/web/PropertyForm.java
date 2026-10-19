package es.uclm.rental_platform.web;

import java.math.BigDecimal;

import es.uclm.rental_platform.domain.PropertyType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Objeto de formulario que contiene y valida los valores enviados al registrar
 * una propiedad.
 *
 * <p>Las restricciones de validación de los campos se aplican al vincular una
 * solicitud con este objeto.
 */
public class PropertyForm {

    /** Título visible de la propiedad; no puede estar vacío. */
    @NotBlank
    private String title;

    /** Texto descriptivo de la propiedad; no puede estar vacío. */
    @NotBlank
    private String description;

    /** Dirección de la propiedad; no puede estar vacía. */
    @NotBlank
    private String address;

    /** Ciudad donde se encuentra la propiedad; no puede estar vacía. */
    @NotBlank
    private String city;

    /** Precio por noche de la propiedad; debe ser positivo y tener como máximo dos decimales. */
    @NotNull
    @DecimalMin("0.01")
    @Digits(integer = 17, fraction = 2)
    private BigDecimal pricePerNight;

    /** Descripción de las comodidades disponibles en la propiedad. */
    @NotBlank
    private String amenities;

    /** Indica si la propiedad es una vivienda completa o una habitación. */
    @NotNull
    private PropertyType type;

    /** Indica si los huéspedes pueden reservar la propiedad de forma inmediata. */
    @NotNull
    private Boolean instantBooking;

    /**
     * Devuelve el título visible de la propiedad.
     *
     * @return el título, o {@code null} si aún no se ha establecido
     */
    public String getTitle() {
        return title;
    }

    /**
     * Establece el título visible de la propiedad.
     *
     * @param title título que se asignará
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Devuelve el texto descriptivo de la propiedad.
     *
     * @return la descripción, o {@code null} si aún no se ha establecido
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece el texto descriptivo de la propiedad.
     *
     * @param description descripción que se asignará
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la dirección de la propiedad.
     *
     * @return la dirección, o {@code null} si aún no se ha establecido
     */
    public String getAddress() {
        return address;
    }

    /**
     * Establece la dirección de la propiedad.
     *
     * @param address dirección que se asignará
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Devuelve la ciudad donde se encuentra la propiedad.
     *
     * @return la ciudad, o {@code null} si aún no se ha establecido
     */
    public String getCity() {
        return city;
    }

    /**
     * Establece la ciudad donde se encuentra la propiedad.
     *
     * @param city ciudad que se asignará
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Devuelve el precio por noche de la propiedad.
     *
     * @return el precio por noche, o {@code null} si aún no se ha establecido
     */
    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Establece el precio por noche de la propiedad.
     *
     * @param pricePerNight precio por noche que se asignará
     */
    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    /**
     * Devuelve la descripción de las comodidades de la propiedad.
     *
     * @return las comodidades, o {@code null} si aún no se han establecido
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * Establece la descripción de las comodidades de la propiedad.
     *
     * @param amenities comodidades que se asignarán
     */
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    /**
     * Devuelve la categoría de la propiedad.
     *
     * @return el tipo de propiedad, o {@code null} si aún no se ha establecido
     */
    public PropertyType getType() {
        return type;
    }

    /**
     * Establece la categoría de la propiedad.
     *
     * @param type tipo de propiedad que se asignará
     */
    public void setType(PropertyType type) {
        this.type = type;
    }

    /**
     * Indica si la propiedad permite la reserva inmediata.
     *
     * @return {@code true} si la reserva inmediata está habilitada, {@code false}
     *         en caso contrario, o {@code null} si aún no se ha establecido el valor
     */
    public Boolean getInstantBooking() {
        return instantBooking;
    }

    /**
     * Establece si la propiedad permite la reserva inmediata.
     *
     * @param instantBooking {@code true} para habilitar la reserva inmediata;
     *                       {@code false} para deshabilitarla
     */
    public void setInstantBooking(Boolean instantBooking) {
        this.instantBooking = instantBooking;
    }
}
