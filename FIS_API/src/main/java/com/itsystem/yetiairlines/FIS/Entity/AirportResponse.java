package com.itsystem.yetiairlines.FIS.Entity;
import java.util.List;


public class AirportResponse {
    private int code;
    private String message;
    private List<Airport_Entity> data;

    // Constructor
    public AirportResponse(int code, String message, List<Airport_Entity> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public List<Airport_Entity> getData() { return data; }
    public void setData(List<Airport_Entity> data) { this.data = data; }
}
