package com.amadeuscankatsezer.casestudy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


/**
 * @author Cankat Sezer
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime arrivalDate;
    private Double price;
}
