package com.itsystem.yetiairlines.FIS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FisStatus_Entity {

    @Id
    @Column(name = "FlightStatusKey")
    String statusKey;

    @Column(name = "FlightStatus")
    String status;

}
