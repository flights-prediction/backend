package com.backend.aiplane.domain.flightInfo.domain;

import com.backend.aiplane.domain.route.domain.Route;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_info_id")
    private Long id;

    private LocalDate departureDate;

    private LocalTime departureTime;

    private LocalDateTime arriveDateTime;
    private Integer price;

    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;

    private String airline;
}
