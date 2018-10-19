package com.jee.capteurListener.exception;

import com.jee.capteurListener.dto.NatureEnum;

public class UnknownNatureException extends Exception {

    public UnknownNatureException(String nature){
        super("Nature de mesure inconnue : " + nature);
    }
}
