package com.itsystem.yetiairlines.FIS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FisRemarks_Entity {

    @Id
    @Column(name = "FlightRemarksKey")
    String flightKey;

    @Column (name = "FlightRemarks")
    String remarks;
}
