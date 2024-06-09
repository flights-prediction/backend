package com.backend.aiplane.domain.price.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightPriceInfoRepository extends JpaRepository<FlightPriceInfo, Long> {
    @Query("SELECT f FROM FlightPriceInfo f WHERE f.flightInfo.id = :flightInfoId ORDER BY f.search_date ASC")
    List<FlightPriceInfo> getAllByFlightInfoIdOrderBySearch_dateAsc(Long flightInfoId);
}
