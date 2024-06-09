package com.backend.aiplane.domain.price.presentation.dto;

import java.util.List;

public record FlightPriceInfoResponses(
        List<FlightPriceInfoResponse> flightPriceInfoResponseList) {
}
