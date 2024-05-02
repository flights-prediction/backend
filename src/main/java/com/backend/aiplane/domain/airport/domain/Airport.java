package com.backend.aiplane.domain.airport.domain;

import com.backend.aiplane.domain.country.domain.Country;
import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Long id;

    private String name;

    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
