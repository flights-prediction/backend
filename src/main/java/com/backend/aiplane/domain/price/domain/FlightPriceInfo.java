package com.backend.aiplane.domain.price.domain;

import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FlightPriceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_price_info_id")
    private Long id;

    private LocalDateTime search_date;

    private Integer predictedPrice;


    @ManyToOne
    @JoinColumn(name = "flight_info_id")
    private FlightInfo flightInfo;
}
