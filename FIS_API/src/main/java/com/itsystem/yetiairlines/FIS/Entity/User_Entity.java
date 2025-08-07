package com.itsystem.yetiairlines.FIS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User_Entity {

    @Id
    @Column(name = "user_account_id")
    private String userid;

    @Column(name = "user_logon")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_code")
    private String airport;

}
