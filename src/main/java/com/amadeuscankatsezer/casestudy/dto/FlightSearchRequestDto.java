package com.amadeuscankatsezer.casestudy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Cankat Sezer
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightSearchRequestDto {
    private String departureAirport;
    private String arrivalAirport;
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate departureDate;
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate returnDate;
}
