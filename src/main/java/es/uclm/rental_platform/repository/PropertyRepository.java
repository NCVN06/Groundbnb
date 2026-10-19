package es.uclm.rental_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uclm.rental_platform.domain.Property;

/**
 * Proporciona operaciones de persistencia para las entidades {@link Property}.
 *
 * <p>Hereda las operaciones CRUD de {@link JpaRepository}.
 */
public interface PropertyRepository extends JpaRepository<Property, Long> {
}