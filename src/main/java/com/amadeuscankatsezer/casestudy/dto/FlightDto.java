package com.amadeuscankatsezer.casestudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Cankat Sezer
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long departureAirportId;
    private Long arrivalAirportId;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Double price;
}
