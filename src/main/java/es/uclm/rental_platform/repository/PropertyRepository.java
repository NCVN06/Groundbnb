package es.uclm.rental_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uclm.rental_platform.domain.Property;

/**
 * Proporciona operaciones de persistencia para las entidades {@link Property}.
 *
 * <p>Hereda las operaciones CRUD de {@link JpaRepository}.
 */
public interface PropertyRepository extends JpaRepository<Property, Long> {

    /**
     * Busca propiedades cuyo título, descripción, dirección o ciudad contenga el
     * texto indicado, sin distinguir entre mayúsculas y minúsculas.
     *
     * @param query texto buscado en los campos descriptivos y de ubicación
     * @return propiedades que coinciden con alguno de los campos
     */
    @Query("""
            select property from Property property
            where lower(property.title) like lower(concat('%', :query, '%'))
                or lower(property.description) like lower(concat('%', :query, '%'))
                or lower(property.address) like lower(concat('%', :query, '%'))
                or lower(property.city) like lower(concat('%', :query, '%'))
            """)
    List<Property> searchByText(@Param("query") String query);
}