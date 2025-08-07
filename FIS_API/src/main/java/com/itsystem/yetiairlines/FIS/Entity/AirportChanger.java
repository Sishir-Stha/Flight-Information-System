package com.itsystem.yetiairlines.FIS.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportChanger {
    private String AirportName;
    public String getAirport(String Airport){
        switch(Airport){
            case "TAP":
                AirportName = "KATHMANDU";
                break;
            case "PKR":
                AirportName = "POKHARA";
                break;
            case "BIR":
                AirportName = "BIRATNAGAR";
                break;
            case "BWA":
                AirportName = "BHAIRAHAWA";
                break;
            case "JKR":
                AirportName = "JANAKPUR";
                break;
            case "KEP":
                AirportName = "NEPALGUNJ";
                break;
            case "SIF":
                AirportName = "SIMARA";
                break;
            case "BDP":
                AirportName = "BHADRAPUR";
                break;
            default:
                AirportName = "N/A";
        }
        return AirportName;
    }
}