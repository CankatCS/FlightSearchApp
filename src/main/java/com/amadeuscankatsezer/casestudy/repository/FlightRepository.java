package com.amadeuscankatsezer.casestudy.repository;

import com.amadeuscankatsezer.casestudy.model.Airport;
import com.amadeuscankatsezer.casestudy.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author Cankat Sezer
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateBetween(Airport departureAirport, Airport arrivalAirport, LocalDateTime startDate, LocalDateTime endDate);
}
