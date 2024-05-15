package com.backend.aiplane.domain.flightInfo.domain;

import com.backend.aiplane.domain.route.domain.Route;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_info_id")
    private Long id;

    private LocalDate departureDate;

    private LocalDateTime departureTime;

    private LocalDateTime arriveTime;

    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;

    private String airline;
}
