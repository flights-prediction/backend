package com.backend.aiplane.domain.price.presentation;

import com.backend.aiplane.domain.flightInfo.application.FlightInfoService;
import com.backend.aiplane.domain.flightInfo.application.dto.FlightInfoSearchDto;
import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import com.backend.aiplane.domain.flightInfo.presentation.dto.request.FlightInfoSearchRequest;
import com.backend.aiplane.domain.flightInfo.presentation.dto.response.FlightInfoSearchResponse;
import com.backend.aiplane.domain.flightInfo.presentation.dto.response.FlightInfoSearchResponses;
import com.backend.aiplane.domain.price.application.FlightPriceInfoService;
import com.backend.aiplane.domain.price.domain.FlightPriceInfo;
import com.backend.aiplane.domain.price.presentation.dto.FlightPriceInfoResponse;
import com.backend.aiplane.domain.price.presentation.dto.FlightPriceInfoResponses;
import com.backend.aiplane.global.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flightPriceInfos")
public class FlightPriceInfoController {
    private final FlightPriceInfoService flightPriceInfoService;

    @Operation(description = "항공권 가격 변동 내역 조회를 위한 REST API.")
    @GetMapping("/{flightInfoId}")
    public ResponseEntity<SuccessResponse<FlightPriceInfoResponses>> getFlightInfoHistories(
            @PathVariable Long flightInfoId
    ) {
        List<FlightPriceInfo> flightPriceInfos = flightPriceInfoService.getPriceINfoHistory(flightInfoId);
        List<FlightPriceInfoResponse> flightPriceInfoResponses = convertToListResponse(flightPriceInfos);

        return SuccessResponse.of(new FlightPriceInfoResponses(flightPriceInfoResponses));
    }

    private List<FlightPriceInfoResponse> convertToListResponse(List<FlightPriceInfo> flightPriceInfos) {
        return flightPriceInfos.stream().map(
                (e) -> {
                    return new FlightPriceInfoResponse(e.getSearch_date(), e.getPredictedPrice(), e.getFlightInfo().getId());
                }
        ).toList();
    }
}
