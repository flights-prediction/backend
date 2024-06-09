package com.backend.aiplane.domain.price.application;

import com.backend.aiplane.domain.flightInfo.application.FlightInfoService;
import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import com.backend.aiplane.domain.price.domain.FlightPriceInfo;
import com.backend.aiplane.domain.price.domain.FlightPriceInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightPriceInfoService {
    private final FlightInfoService flightInfoService;
    private final FlightPriceInfoRepository flightPriceInfoRepository;

    public List<FlightPriceInfo> getPriceINfoHistory(Long flightInfoId){
        FlightInfo flightInfo = flightInfoService.getFlightInfoById(flightInfoId);
        return flightPriceInfoRepository.getAllByFlightInfoIdOrderBySearch_dateAsc(flightInfoId);
    }
}
