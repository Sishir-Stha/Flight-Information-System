package com.itsystem.yetiairlines.FIS.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Edit_Entity {
    @Id
    @Column(name = "flightNumber")
    String  flightNo;

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
