package com.backend.aiplane.domain.flightInfo.domain;

import com.backend.aiplane.domain.flightInfo.application.dto.FlightInfoSearchDto;

import java.util.List;

public interface CustomFlightInfoRepository {
    List<FlightInfo> findFlightInfosByCriteria(FlightInfoSearchDto dto);
}
