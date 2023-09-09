package com.amadeuscankatsezer.casestudy.repository;

import com.amadeuscankatsezer.casestudy.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Cankat Sezer
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByCity(String city);
}
