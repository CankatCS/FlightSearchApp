package com.amadeuscankatsezer.casestudy.scheduler;

import com.amadeuscankatsezer.casestudy.dto.FlightDto;
import com.amadeuscankatsezer.casestudy.mockapi.MockAPI;
import com.amadeuscankatsezer.casestudy.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Cankat Sezer
 */
@Component
@RequiredArgsConstructor
public class ScheduledFlightDataFetcher {

    private final FlightService flightService;
    private final MockAPI mockAPI;

    @Scheduled(cron = "0 11 1 * * *")
    public void fetchAndSaveFlightData() {
        List<FlightDto> flights = mockAPI.fetchFlightData();
        flightService.saveFlights(flights);
    }
}


