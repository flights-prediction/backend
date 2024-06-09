package com.backend.aiplane.domain.price.domain;

import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class FlightPriceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_price_info_id")
    private Long id;

    private LocalDate search_date;

    private Long predictedPrice;

    @ManyToOne
    @JoinColumn(name = "flight_info_id")
    private FlightInfo flightInfo;
}
