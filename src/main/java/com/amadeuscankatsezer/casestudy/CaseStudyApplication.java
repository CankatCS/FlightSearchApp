package com.amadeuscankatsezer.casestudy;

import com.amadeuscankatsezer.casestudy.dto.AirportDto;
import com.amadeuscankatsezer.casestudy.service.AirportService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner initializeData(AirportService airportService) {
        return args -> {
            addDefaultAirports(airportService);
        };
    }

    private void addDefaultAirports(AirportService airportService) {
        for (int i = 1; i <= 20; i++) {
            AirportDto airportDto = AirportDto.builder()
                    .city("City " + i)
                    .build();
            airportService.createAirport(airportDto);
        }
    }

}