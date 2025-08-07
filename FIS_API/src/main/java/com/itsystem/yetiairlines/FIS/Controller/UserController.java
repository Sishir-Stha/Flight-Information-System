package com.itsystem.yetiairlines.FIS.Controller;


import com.itsystem.yetiairlines.FIS.Authenticator.JwtTokenUtil;
import com.itsystem.yetiairlines.FIS.Entity.AirportChanger;
import com.itsystem.yetiairlines.FIS.Entity.LoginRequest;
import com.itsystem.yetiairlines.FIS.Entity.LoginResponse;
import com.itsystem.yetiairlines.FIS.Entity.User_Entity;
import com.itsystem.yetiairlines.FIS.Services.UserServices;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/userdata")
    public ResponseEntity<?> userbyname(@RequestParam String username , @RequestParam String password){
        User_Entity user = userServices.userdata(username, password);
        if (user != null){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession httpSession){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        System.out.println("Received username: " + username+ " and password: " + password);

        User_Entity userdata = userServices.userdata(username,password);
        String AirportCode = userdata.getAirport();
        System.out.println(" Airport Code : " + AirportCode);
        AirportChanger airportChanger = new AirportChanger();
        String Airport = airportChanger.getAirport(AirportCode);
        System.out.println("Airport Name : " + Airport);
        if(userdata != null){
            String token = JwtTokenUtil.generateToken(username);
            return ResponseEntity.ok(new LoginResponse(token,Airport));
        } else {
            System.out.println(" User Doesnot Exits !!");
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @GetMapping("/checkLogin")
    public ResponseEntity<?> checkLogin(HttpSession session) {
        Long userID = (Long) session.getAttribute("userID");
        if (userID != null) {
            return ResponseEntity.ok("User is logged in with userID: " + userID);
        } else {
            return ResponseEntity.status(401).body("User not logged in");
        }
    }
}


