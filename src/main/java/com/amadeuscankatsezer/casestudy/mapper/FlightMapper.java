package com.amadeuscankatsezer.casestudy.mapper;

import com.amadeuscankatsezer.casestudy.dto.FlightDto;
import com.amadeuscankatsezer.casestudy.model.Airport;
import com.amadeuscankatsezer.casestudy.model.Flight;
import com.amadeuscankatsezer.casestudy.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Cankat Sezer
 */
@Component
@RequiredArgsConstructor
public class FlightMapper {

    private final AirportService airportService;

    public FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setDepartureAirportId(flight.getDepartureAirport().getId());
        flightDto.setArrivalAirportId(flight.getArrivalAirport().getId());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setArrivalDate(flight.getArrivalDate());
        flightDto.setPrice(flight.getPrice());
        return flightDto;
    }

    public Flight toEntity(FlightDto flightDto) {
        Flight flight = new Flight();
        Airport departureAirport = airportService.findById(flightDto.getDepartureAirportId());
        departureAirport.setId(flightDto.getDepartureAirportId());
        Airport arrivalAirport = airportService.findById(flightDto.getArrivalAirportId());
        arrivalAirport.setId(flightDto.getArrivalAirportId());
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setArrivalDate(flightDto.getArrivalDate());
        flight.setPrice(flightDto.getPrice());
        return flight;
    }

    public List<FlightDto> toDtoList(List<Flight> flightList) {
        return flightList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Flight> toEntityList(List<FlightDto> flightDtoList) {
        return flightDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}



