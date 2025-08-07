package com.itsystem.yetiairlines.FIS.Services;

import com.itsystem.yetiairlines.FIS.Entity.User_Entity;
import com.itsystem.yetiairlines.FIS.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServices {
    @Autowired
    private UserRepository userRepository;


    public User_Entity userdata(String username, String password){
        return userRepository.userdata(username,password);
    }

}
