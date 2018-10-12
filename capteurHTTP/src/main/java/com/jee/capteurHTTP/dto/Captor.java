package com.jee.capteurHTTP.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Captor {
    private Location location;
    private int id;

    private Captor(){
        //no-op
    }
}
