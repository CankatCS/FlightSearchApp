package com.amadeuscankatsezer.casestudy.controller;

import com.amadeuscankatsezer.casestudy.dto.FlightDto;
import com.amadeuscankatsezer.casestudy.dto.FlightSearchRequestDto;
import com.amadeuscankatsezer.casestudy.dto.FlightSearchResponseDto;
import com.amadeuscankatsezer.casestudy.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cankat Sezer
 */
@RequestMapping("/api/v1/search")
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<FlightSearchResponseDto> searchFlights(@Valid @RequestBody FlightSearchRequestDto request) {
        if (request.getReturnDate() != null) {
            List<FlightDto> departingFlights = flightService.searchFlights(request.getDepartureAirport(), request.getArrivalAirport(), request.getDepartureDate());
            List<FlightDto> returningFlights = flightService.searchFlights(request.getArrivalAirport(), request.getDepartureAirport(), request.getReturnDate());

            Map<String, List<FlightDto>> flightsMap = new HashMap<>();
            flightsMap.put("departingFlights", departingFlights);
            flightsMap.put("returningFlights", returningFlights);

            FlightSearchResponseDto response = FlightSearchResponseDto.builder().flights(flightsMap).build();
            return ResponseEntity.ok().body(response);
        } else {
            List<FlightDto> oneWayFlights = flightService.searchFlights(request.getDepartureAirport(), request.getArrivalAirport(), request.getDepartureDate());
            FlightSearchResponseDto response = FlightSearchResponseDto.builder().flights(Collections.singletonMap("oneWayFlights", oneWayFlights)).build();
            return ResponseEntity.ok().body(response);
        }
    }
}

