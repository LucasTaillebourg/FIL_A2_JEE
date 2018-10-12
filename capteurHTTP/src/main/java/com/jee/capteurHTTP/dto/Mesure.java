package com.jee.capteurHTTP.dto;

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
    private NatureEnum nature;
    private LocalDateTime date;
    private float value;

    private Mesure(){
        //no-op
    }
}
