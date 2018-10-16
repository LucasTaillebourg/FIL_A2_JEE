package com.jee.capteurListener.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Mesure {
    private Location location;
    private String capteurID;
    private NatureEnum nature;
    private LocalDateTime date;
    private float value;
}
