package com.itsystem.yetiairlines.FIS.Entity;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String Airport;
    public LoginResponse(String token, String Airport) {
        this.token = token;
        this.Airport = Airport;
    }

}
