package com.amadeuscankatsezer.casestudy.mapper;

import com.amadeuscankatsezer.casestudy.dto.AirportDto;
import com.amadeuscankatsezer.casestudy.model.Airport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Cankat Sezer
 */
@Component
@RequiredArgsConstructor
public class AirportMapper {

    public AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setCity(airport.getCity());
        return airportDto;
    }

    public Airport toEntity(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setCity(airportDto.getCity());
        return airport;
    }

    public List<Airport> toEntityList(List<AirportDto> airportDtos) {
        return airportDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public List<AirportDto> toDtoList(List<Airport> airports) {
        return airports.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
