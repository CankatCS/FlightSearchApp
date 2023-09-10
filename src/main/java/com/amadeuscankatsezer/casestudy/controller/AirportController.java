package com.amadeuscankatsezer.casestudy.controller;

import com.amadeuscankatsezer.casestudy.dto.AirportDto;
import com.amadeuscankatsezer.casestudy.service.AirportService;
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
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    @Operation(
            description = "Endpoint to create airport"
    )
    public ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto) {
        AirportDto createdAirport = airportService.createAirport(airportDto);
        return new ResponseEntity<>(createdAirport, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            description = "Endpoint to get all airports"
    )
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        List<AirportDto> airports = airportService.getAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Endpoint to get airport with its id"
    )
    public ResponseEntity<AirportDto> getAirportById(@PathVariable Long id) {
        AirportDto airport = airportService.getAirportById(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            description = "Endpoint to update an airport with its id"
    )
    public ResponseEntity<AirportDto> updateAirport(@PathVariable Long id, @RequestBody AirportDto updatedAirportDto) {
        AirportDto airport = airportService.updateAirport(id, updatedAirportDto);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            description = "Endpoint to delete airport airport"
    )
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}