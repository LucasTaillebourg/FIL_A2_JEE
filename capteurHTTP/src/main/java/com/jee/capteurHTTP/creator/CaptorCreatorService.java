package com.jee.capteurHTTP.creator;

import com.jee.capteurHTTP.dto.Captor;
import com.jee.capteurHTTP.dto.Location;
import org.springframework.stereotype.Service;

@Service
public class CaptorCreatorService {

    private int captorCounter = 0;

    public Captor createCaptor(){
        captorCounter++;
        Location location = Location.builder().city("Nantes").country("France").build();
        return Captor.builder().id(captorCounter).location(location).build();
    }

}
