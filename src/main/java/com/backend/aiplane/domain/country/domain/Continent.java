package com.backend.aiplane.domain.country.domain;

public enum Continent {
    ASIA("Asia"),
    EUROPE("Europe"),
    AFRICA("Africa"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    AUSTRALIA("Australia"),
    ANTARCTICA("Antarctica");

    private final String name;

    Continent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
