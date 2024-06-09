package com.backend.aiplane.domain.airport.domain;

public enum City {
    INCHEON("Incheon"),
    SEOUL("Seoul"),
    JEJU_CITY("Jeju City"),
    BUSAN("Busan"),
    DAEGU("Daegu"),
    CHEONGJU("Cheongju"),
    YANGYANG("Yangyang"),
    MUAN("Muan"),
    HO_CHI_MINH_CITY("Ho Chi Minh City"),
    HANOI("Hanoi"),
    DA_NANG("Da Nang"),
    CAN_THO("Can Tho"),
    CAM_RANH("Cam Ranh"),
    HUE("Hue"),
    DONG_HOI("Dong Hoi");

    private final String displayName;

    // Constructor
    City(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return this.displayName;
    }
}