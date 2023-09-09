package com.amadeuscankatsezer.casestudy.service;

import com.amadeuscankatsezer.casestudy.dto.AirportDto;
import com.amadeuscankatsezer.casestudy.mapper.AirportMapper;
import com.amadeuscankatsezer.casestudy.model.Airport;
import com.amadeuscankatsezer.casestudy.repository.AirportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Cankat Sezer
 */
@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public Airport findById(Long id) {
        return airportRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + id));
    }

    public AirportDto createAirport(AirportDto airportDto) {
        Airport airport = airportMapper.toEntity(airportDto);
        Airport savedAirport = airportRepository.save(airport);
        return airportMapper.toDto(savedAirport);
    }

    public List<AirportDto> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airportMapper.toDtoList(airports);
    }

    public AirportDto getAirportById(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + id));
        return airportMapper.toDto(airport);
    }

    public AirportDto updateAirport(Long id, AirportDto updatedAirportDto) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + id));
        Airport updatedAirport = airportMapper.toEntity(updatedAirportDto);
        airport.setCity(updatedAirport.getCity());
        airport = airportRepository.save(airport);
        return airportMapper.toDto(airport);
    }

    public void deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + id));
        airportRepository.delete(airport);
    }

    public Airport findByCity(String city) {
        return airportRepository.findByCity(city).orElseThrow(()->new EntityNotFoundException("Airport not found with given city name"));
    }
}