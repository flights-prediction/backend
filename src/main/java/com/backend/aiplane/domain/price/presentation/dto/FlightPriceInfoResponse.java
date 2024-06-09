package com.backend.aiplane.domain.price.presentation.dto;

import java.time.LocalDate;

public record FlightPriceInfoResponse(
        LocalDate search_date,
        Long predictedPrice,
        Long flightInfoId) {
}
