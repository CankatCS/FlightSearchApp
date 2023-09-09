package com.amadeuscankatsezer.casestudy.service;

import com.amadeuscankatsezer.casestudy.dto.FlightDto;
import com.amadeuscankatsezer.casestudy.mapper.FlightMapper;
import com.amadeuscankatsezer.casestudy.model.Airport;
import com.amadeuscankatsezer.casestudy.model.Flight;
import com.amadeuscankatsezer.casestudy.repository.FlightRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


/**
 * @author Cankat Sezer
 */
@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirportService airportService;
    private final FlightMapper flightMapper;

    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.toDto(savedFlight);
    }

    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flightMapper.toDtoList(flights);
    }

    public FlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight cannot found with id: " + id));
        return flightMapper.toDto(flight);
    }

    public FlightDto updateFlight(Long id, FlightDto updatedFlightDto) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight cannot found with id: " + id));
        Flight updatedFlight = flightMapper.toEntity(updatedFlightDto);
        flight.setDepartureAirport(updatedFlight.getDepartureAirport());
        flight.setArrivalAirport(updatedFlight.getArrivalAirport());
        flight.setDepartureDate(updatedFlight.getDepartureDate());
        flight.setArrivalDate(updatedFlight.getArrivalDate());
        flight.setPrice(updatedFlight.getPrice());
        flight = flightRepository.save(flight);
        return flightMapper.toDto(flight);
    }

    public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight cannot found with id: " + id));
        flightRepository.delete(flight);
    }

    public void saveFlights(List<FlightDto> flightDtos) {
        List<Flight> flights = flightMapper.toEntityList(flightDtos);
        flightRepository.saveAll(flights);
    }

    public List<FlightDto> searchFlights(String departureAirportCity, String arrivalAirportCity, LocalDate date) {
        Airport departureAirport = airportService.findByCity(departureAirportCity);
        Airport arrivalAirport = airportService.findByCity(arrivalAirportCity);

        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = date.atTime(LocalTime.MAX);

        List<Flight> matchingFlights = flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateBetween(
                departureAirport, arrivalAirport, startDate, endDate);

        return flightMapper.toDtoList(matchingFlights);
    }
}