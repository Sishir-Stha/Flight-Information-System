package com.itsystem.yetiairlines.FIS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Airport_Entity {
    @Id
    @Column(name = "RowNum")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column (name = "is_active")
    private Boolean is_active;

}
