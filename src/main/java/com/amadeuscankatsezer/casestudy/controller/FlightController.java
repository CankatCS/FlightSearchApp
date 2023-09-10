package com.amadeuscankatsezer.casestudy.controller;

import com.amadeuscankatsezer.casestudy.dto.FlightDto;
import com.amadeuscankatsezer.casestudy.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Cankat Sezer
 */
@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    @Operation(
            description = "Endpoint to create flight"
    )
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        FlightDto createdFlight = flightService.createFlight(flightDto);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            description = "Endpoint to get all flights on database"
    )
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Endpoint to get a flight data with given id"
    )
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        FlightDto flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            description = "Endpoint to update a flight data with given id"
    )
    public ResponseEntity<FlightDto> updateFlight(@PathVariable Long id, @RequestBody FlightDto updatedFlightDto) {
        FlightDto flight = flightService.updateFlight(id, updatedFlightDto);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            description = "Endpoint to delete the flight with given id"
    )
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}