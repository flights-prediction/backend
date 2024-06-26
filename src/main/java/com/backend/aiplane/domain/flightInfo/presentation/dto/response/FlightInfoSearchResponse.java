package com.backend.aiplane.domain.flightInfo.presentation.dto.response;

import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import com.backend.aiplane.domain.route.domain.Route;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record FlightInfoSearchResponse(
        Long flightInfoId,
        LocalDate departureDate,
        LocalTime departureTime,
        LocalTime arriveTime,

        Route route,
        String airline
) {
    public FlightInfoSearchResponse(FlightInfo flightInfo){
        this(flightInfo.getId(),
                flightInfo.getDepartureDate(),
                flightInfo.getDepartureTime(),
                flightInfo.getArriveTime(),
                flightInfo.getRoute(),
                flightInfo.getAirline());
    }
}
