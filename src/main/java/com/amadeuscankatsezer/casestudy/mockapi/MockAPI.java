package com.amadeuscankatsezer.casestudy.mockapi;

import com.amadeuscankatsezer.casestudy.dto.FlightDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Cankat Sezer
 */
@Component
@RequiredArgsConstructor
public class MockAPI {
    public List<FlightDto> fetchFlightData() {

        List<FlightDto> mockFlights = new ArrayList<>();

        FlightDto flight1 = FlightDto.builder()
                .departureAirportId(1L)
                .arrivalAirportId(2L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(201.0)
                .build();
        mockFlights.add(flight1);

        FlightDto flight2 = FlightDto.builder()
                .departureAirportId(2L)
                .arrivalAirportId(3L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(202.0)
                .build();
        mockFlights.add(flight2);

        FlightDto flight3 = FlightDto.builder()
                .departureAirportId(3L)
                .arrivalAirportId(2L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(203.0)
                .build();
        mockFlights.add(flight3);

        FlightDto flight4 = FlightDto.builder()
                .departureAirportId(4L)
                .arrivalAirportId(5L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(204.0)
                .build();
        mockFlights.add(flight4);

        FlightDto flight5 = FlightDto.builder()
                .departureAirportId(5L)
                .arrivalAirportId(6L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(205.0)
                .build();
        mockFlights.add(flight5);

        FlightDto flight6 = FlightDto.builder()
                .departureAirportId(7L)
                .arrivalAirportId(8L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(206.0)
                .build();
        mockFlights.add(flight6);

        FlightDto flight7 = FlightDto.builder()
                .departureAirportId(9L)
                .arrivalAirportId(10L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(207.0)
                .build();
        mockFlights.add(flight7);

        FlightDto flight8 = FlightDto.builder()
                .departureAirportId(2L)
                .arrivalAirportId(1L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(208.0)
                .build();
        mockFlights.add(flight8);

        FlightDto flight9 = FlightDto.builder()
                .departureAirportId(5L)
                .arrivalAirportId(3L)
                .departureDate(LocalDateTime.now())
                .arrivalDate(LocalDateTime.now().plusHours(2))
                .price(209.0)
                .build();
        mockFlights.add(flight9);

        FlightDto flight10 = FlightDto.builder()
                .departureAirportId(3L)
                .arrivalAirportId(5L)
                .departureDate(LocalDateTime.now().plusDays(1))
                .arrivalDate(LocalDateTime.now().plusDays(1).plusHours(2))
                .price(210.0)
                .build();
        mockFlights.add(flight10);
        return mockFlights;
    }
}