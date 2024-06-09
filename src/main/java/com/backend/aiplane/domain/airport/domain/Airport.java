package com.backend.aiplane.domain.airport.domain;

import com.backend.aiplane.domain.country.domain.Country;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @Enumerated(EnumType.STRING)
    private City city;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
