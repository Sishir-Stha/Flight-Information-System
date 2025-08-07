package com.itsystem.yetiairlines.FIS.Repositories;

import com.itsystem.yetiairlines.FIS.Entity.User_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User_Entity, String > {


    @Query(value = "EXEC uspGetAvantikUserAccount :username,:password", nativeQuery = true)
    User_Entity userdata(String username, String password);

}
