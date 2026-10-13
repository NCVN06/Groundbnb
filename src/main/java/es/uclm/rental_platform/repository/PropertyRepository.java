package es.uclm.rental_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uclm.rental_platform.domain.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}