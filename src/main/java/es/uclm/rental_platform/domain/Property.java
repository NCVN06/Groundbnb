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

/**
 * Representación persistente de una propiedad de alquiler ofrecida en la
 * plataforma.
 */
@Entity
@Table(name = "properties")
public class Property {

    /** Identificador de esta propiedad generado por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Título visible de la propiedad. */
    @Column(nullable = false)
    private String title;

    /** Texto descriptivo de la propiedad. */
    @Column(nullable = false)
    private String description;

    /** Dirección de la propiedad. */
    @Column(nullable = false)
    private String address;

    /** Ciudad donde se encuentra la propiedad. */
    @Column(nullable = false)
    private String city;

    /** Precio cobrado por una noche. */
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal pricePerNight;

    /** Descripción de las comodidades disponibles en la propiedad. */
    @Column(nullable = false)
    private String amenities;

    /** Tipo de esta propiedad. */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyType type;

    /** Indica si los huéspedes pueden reservar esta propiedad de forma inmediata. */
    @Column(nullable = false)
    private boolean instantBooking;

    /**
     * Crea una instancia vacía de la entidad para su uso por JPA.
     */
    protected Property() {
    }

    /**
     * Crea una propiedad con los datos de registro proporcionados.
     *
     * @param title título visible de la propiedad
     * @param description texto descriptivo de la propiedad
     * @param address dirección de la propiedad
     * @param city ciudad donde se encuentra la propiedad
     * @param pricePerNight precio cobrado por una noche
     * @param amenities descripción de las comodidades de la propiedad
     * @param type tipo de la propiedad
     * @param instantBooking indica si los huéspedes pueden reservar la propiedad
     *        de forma inmediata
     */
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

    /**
     * Devuelve el identificador generado por la base de datos.
     *
     * @return el identificador, o {@code null} antes de persistir la entidad
     */
    public Long getId() {
        return id;
    }

    /**
     * Devuelve el título visible de la propiedad.
     *
     * @return el título
     */
    public String getTitle() {
        return title;
    }

    /**
     * Devuelve el texto descriptivo de la propiedad.
     *
     * @return la descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Devuelve la dirección de la propiedad.
     *
     * @return la dirección
     */
    public String getAddress() {
        return address;
    }

    /**
     * Devuelve la ciudad donde se encuentra la propiedad.
     *
     * @return la ciudad
     */
    public String getCity() {
        return city;
    }

    /**
     * Devuelve el precio cobrado por una noche.
     *
     * @return el precio por noche
     */
    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Devuelve la descripción de las comodidades de la propiedad.
     *
     * @return las comodidades
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * Devuelve el tipo de la propiedad.
     *
     * @return el tipo de propiedad
     */
    public PropertyType getType() {
        return type;
    }

    /**
     * Indica si los huéspedes pueden reservar esta propiedad de forma inmediata.
     *
     * @return {@code true} si la reserva inmediata está habilitada; {@code false}
     *         en caso contrario
     */
    public boolean isInstantBooking() {
        return instantBooking;
    }
}
