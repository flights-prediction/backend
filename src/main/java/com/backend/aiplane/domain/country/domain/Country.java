package com.backend.aiplane.domain.country.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Continent continent;
}
