package com.backend.aiplane.domain.flightInfo.presentation;

import com.backend.aiplane.domain.flightInfo.application.FlightInfoService;
import com.backend.aiplane.domain.flightInfo.application.dto.FlightInfoSearchDto;
import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import com.backend.aiplane.domain.flightInfo.presentation.dto.request.FlightInfoSearchRequest;
import com.backend.aiplane.domain.flightInfo.presentation.dto.response.FlightInfoSearchResponse;
import com.backend.aiplane.domain.flightInfo.presentation.dto.response.FlightInfoSearchResponses;
import com.backend.aiplane.domain.like.application.LikeService;
import com.backend.aiplane.domain.user.application.dto.UserResponse;
import com.backend.aiplane.global.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/flightInfos")
public class FlightInfoController {
    private final FlightInfoService flightInfoService;
    private final LikeService likeService;
    private final ModelMapper modelMapper;

    @Operation(description = "항공권 정보 조회를 위한 REST API.")
    @GetMapping()
    public ResponseEntity<SuccessResponse<FlightInfoSearchResponses>> getFlightInfos(
            @ModelAttribute FlightInfoSearchRequest flightInfoSearchRequest

    ) {
        FlightInfoSearchDto dto = new FlightInfoSearchDto(flightInfoSearchRequest);
        List<FlightInfo> flightInfos = flightInfoService.searchFlightInfo(dto);
        List<FlightInfoSearchResponse> flightInfoSearchResponses = convertToResponse(flightInfos);
        return SuccessResponse.of(new FlightInfoSearchResponses(flightInfoSearchResponses));
    }

    @Operation(description = "유저가 찜한 항공권 정보를 조회하는 REST API.")
    @GetMapping("/user/{userId}/like")
    public ResponseEntity<SuccessResponse<FlightInfoSearchResponses>> getFlightInfosOfUserLikes(
            @PathVariable Long userId

    ) {
        List<FlightInfo> flightInfos = likeService.searchUserLikeFlightInfo(userId);
        List<FlightInfoSearchResponse> flightInfoSearchResponses = convertToResponse(flightInfos);
        return SuccessResponse.of(new FlightInfoSearchResponses(flightInfoSearchResponses));
    }

    private List<FlightInfoSearchResponse> convertToResponse(List<FlightInfo> flightInfos) {
        return flightInfos.stream().map(
                (e) -> {
                    return new FlightInfoSearchResponse(e);
                }
        ).toList();
    }
}
