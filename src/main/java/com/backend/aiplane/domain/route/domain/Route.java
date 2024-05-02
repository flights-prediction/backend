package com.backend.aiplane.domain.route.domain;

import com.backend.aiplane.domain.airport.domain.Airport;
import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrive_airport_id")
    private Airport arriveAirportId;
}
