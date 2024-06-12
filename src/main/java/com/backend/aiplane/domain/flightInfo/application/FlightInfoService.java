package com.backend.aiplane.domain.flightInfo.application;

import com.backend.aiplane.domain.flightInfo.application.dto.FlightInfoSearchDto;
import com.backend.aiplane.domain.flightInfo.domain.CustomFlightInfoRepositoryImpl;
import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import com.backend.aiplane.domain.flightInfo.domain.FlightInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FlightInfoService {
    private final FlightInfoRepository flightInfoRepository;
    private final CustomFlightInfoRepositoryImpl customFlightInfoRepository;

    @Transactional
    public List<FlightInfo> searchFlightInfo(FlightInfoSearchDto dto) {
        return  customFlightInfoRepository.findFlightInfosByCriteria(dto);
    }

    public FlightInfo getFlightInfoById(Long id){
        FlightInfo flightInfo = flightInfoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("no flightInfo id = " + id)
        );

        return flightInfo;
    }


}
