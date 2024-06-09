package com.backend.aiplane.domain.flightInfo.application.dto;

import com.backend.aiplane.domain.airport.domain.City;
import com.backend.aiplane.domain.flightInfo.presentation.dto.request.FlightInfoSearchRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class FlightInfoSearchDto {
    private City departureCity;
    private City arriveCity;
    private LocalDate departureDate;
    private String airline;
    private LocalTime departureTime;

    public FlightInfoSearchDto(FlightInfoSearchRequest request) {
        this.departureCity = request.departureCity();
        this.arriveCity = request.arriveCity();
        this.departureDate = request.departureDate();
        this.airline = request.airline();
        this.departureTime = request.departureTime();
    }
}
