package com.backend.aiplane.domain.flightInfo.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_info_id")
    private Long id;

    private String departureDate;

    private String departureTime;

    private String arriveTime;

    private Long routeId;

    private String airline;
}
