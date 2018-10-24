package com.jee.capteurHTTP.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Location {
    String cityId;
    String city;
    String country;
    String countryId;
    String lat;
    String lon;
}
