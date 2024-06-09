package com.backend.aiplane.domain.flightInfo.presentation.dto.request;

import com.backend.aiplane.domain.airport.domain.City;

import java.time.LocalDate;
import java.time.LocalTime;

public record FlightInfoSearchRequest(
        City departureCity,

        City arriveCity,
        LocalDate departureDate,
        String airline,
        LocalTime departureTime
) {

}
