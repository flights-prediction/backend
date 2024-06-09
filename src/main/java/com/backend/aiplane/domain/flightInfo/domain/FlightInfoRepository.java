package com.backend.aiplane.domain.flightInfo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> {
}
