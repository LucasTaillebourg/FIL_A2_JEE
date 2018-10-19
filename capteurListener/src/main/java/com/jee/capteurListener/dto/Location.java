package com.jee.capteurListener.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Location {
    String city;
    String country;
    String lat;
    String lon;
}
