package com.itsystem.yetiairlines.FIS.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class FIS_Entity {

    @Id
    @Column(name = "flight_id")
    String flightId;

    @Column(name = "flightNumber")
    String  flightNo;

    @Column(name = "Origin_Rcd")
    String originRcd;

    @Column(name = "Origin_Name")
    String originName;

    @Column(name = "Destination_Rcd")
    String destinationRcd;

    @Column(name = "Destination_Name")
    String destinationName;

    @Column(name = "Departure_Date")
     String departureDate;

    @Column(name = "Departure_Time")
    String departureTime;

    @Column(name = "FlightStatus")
    String flightStatus;

    @Column(name = "Revised_Time")
    String revisedTime;

    @Column(name = "FlightStatus_Time")
    String flightstatusTime;

    @Column(name = "FlightStatus_Remarks")
    String flightstatusRemarks;

    @Column(name = "Hide")
    String Hide ;
}
