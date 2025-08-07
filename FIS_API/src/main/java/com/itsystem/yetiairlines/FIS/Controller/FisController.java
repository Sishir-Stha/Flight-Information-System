package com.itsystem.yetiairlines.FIS.Controller;


import com.itsystem.yetiairlines.FIS.Entity.*;
import com.itsystem.yetiairlines.FIS.Services.FisServices;

import com.itsystem.yetiairlines.FIS.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/fis")
public class FisController {

    @Autowired
    public FisServices fisServices;

    @Autowired
    public UserServices userServices;


//    @GetMapping("/flightschedule")
//    public ResponseEntity<?> flightSchedule(){
//        List<Airport_Entity> schedule = fisServices.getschedule();
//        if(schedule != null){
//            return ResponseEntity.ok(schedule);
//        }else{
//            return  ResponseEntity.status(404).body("The schedule is fetched");
//        }
//
//    }

    @GetMapping("/flightstatus")
    public ResponseEntity<?> flightstatus(@RequestParam String from,
                                          @RequestParam String to) {
        if (from == null || from == "") {
            System.out.println(" Error : The origin is not given or is empty !");
        }
        if (to == null || to == "") {
            System.out.println(" Error : The destination is not given or is empty !");
        }
        try {
            List<FIS_Entity> data = fisServices.flightstatus(from, to);
            if (data != null) {
                return ResponseEntity.ok(data);
            } else {
                return ResponseEntity.status(404).body("There is No Active flight today !| status");
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error getting the status");
        }
    }

    @GetMapping("/editdata")
    public ResponseEntity<?>editdata(@RequestParam String flightNumber){
        System.out.println("Fetching ther data to edit of : " + flightNumber);
        if (flightNumber == null || flightNumber.isEmpty()) {
            return ResponseEntity.status(400).body("Flight number is required");
        }
        Edit_Entity editEntity = fisServices.edit(flightNumber);
        if (editEntity != null){
            return ResponseEntity.ok(editEntity);
        }else{
            return ResponseEntity.status(404).body("failed to get edit data");
        }
    }
    @GetMapping("/getschedule")
    public ResponseEntity<?> getschedule(@RequestParam String username, @RequestParam String password, @RequestParam String origin ) {

        System.out.println("Received request from : " + username + " and password: " + password);

        User_Entity user = userServices.userdata(username, password);
        if (user != null) {
            try {
                LocalDate today = LocalDate.now();
                System.out.println(today);

                String airport = user.getAirport();
                System.out.println("Airport    : " + user.getAirport());
                if (airport.equals("TAP")) {
                    airport = "KTM";
                }
                System.out.println("Airport    : " + airport);
                System.out.println("Origin Airport   : " + origin);

                List<FIS_Entity> data = fisServices.getschedule(airport, origin);
                if (data != null) {
                    System.out.println(data);
                    return ResponseEntity.ok(data);
                } else {
                    return ResponseEntity.status(404).body("No any flight !! schedule");
                }
            } catch (Exception e) {
                return ResponseEntity.status(404).body("Error getting the schedule");
            }
        } else {
            return ResponseEntity.status(404).body("No user Found !!");
        }
    }

    @GetMapping("/preview")
    public ResponseEntity<?>preview(@RequestParam String username, @RequestParam String password) {
        System.out.println("Received request from : " + username + " and password: " + password);

        User_Entity user = userServices.userdata(username, password);
        if (user != null) {
            try {
                LocalDate today = LocalDate.now();
                System.out.println(today);

                String airport = user.getAirport();
                System.out.println("Airport    : " + user.getAirport());
                if (airport.equals("TAP")) {
                    airport = "KTM";
                }
                System.out.println("Airport    : " + airport);
            List<FIS_Entity>preview = fisServices.preview(airport);
                if (preview != null) {
                    System.out.println(preview);
                    return ResponseEntity.ok(preview);
                } else {
                    return ResponseEntity.status(404).body("No any flight !! schedule");
                }
            } catch (Exception e) {
                return ResponseEntity.status(404).body("Error getting the schedule");
            }
        } else {
            return ResponseEntity.status(404).body("No user Found !!");
        }
    }




    @PutMapping("/updateStatus")
    public ResponseEntity<?> updateStatus(@RequestParam String flightNumber,
                                          @RequestParam String Revised_Time,
                                          @RequestParam String FlightStatus,
                                          @RequestParam String FlightStatus_Remarks,
                                          @RequestParam String username,
                                          @RequestParam String password,
                                          @RequestParam String userid,
                                          @RequestParam int hide,
                                          @RequestParam String FlightStatus_Time) {

        System.out.println("Received request from: " + username);
        System.out.println("UPdating the value ");
        System.out.println(FlightStatus);
        System.out.println(Revised_Time);
        System.out.println(FlightStatus_Remarks);
        System.out.println(hide);

        // Validate user credentials first
        User_Entity user = userServices.userdata(username, password);
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // Verify the provided userid matches the authenticated user
        if (!user.getUserid().equals(userid)) {
            return ResponseEntity.status(403).body("User ID mismatch");
        }

        if (flightNumber == null || flightNumber.isEmpty()) {
            return ResponseEntity.status(400).body("Flight number is required");
        }

        try {
            boolean state = fisServices.update(flightNumber, Revised_Time, FlightStatus,
                    FlightStatus_Remarks, userid,hide, FlightStatus_Time);
            if (state) {
                System.out.println("Successfully Updated the Status");
                return ResponseEntity.ok("Updated");
            } else {
                System.out.println("Failed to update the Status");
                return ResponseEntity.status(500).body("Update failed");
            }
        } catch (Exception e) {
            System.err.println("Failed to update because of Exception: " + e.getMessage());
            return ResponseEntity.status(500).body("Internal server error");
        }
    }

    @GetMapping("/getstatus")
    public ResponseEntity<?> getstatus(){
         List<FisStatus_Entity> status = fisServices.getstatus();
         if (status != null){

             System.out.println("The status is fetched from frontend");
             return ResponseEntity.ok(status);
         }else {
             return ResponseEntity.status(404).body("Failed to fetch the status");
         }
    }


    @GetMapping("/getremarks")
    public ResponseEntity<?> getremarks(){
        List<FisRemarks_Entity> remarks = fisServices.getremarks();
        if (remarks != null){
            System.out.println("The remarks is fetched from frontend");
            return ResponseEntity.ok(remarks);
        }else {
            return ResponseEntity.status(404).body("Failed to fetch the remarks");
        }
    }

    @GetMapping("/airport")
    public ResponseEntity<?> getingairport() {
        List<Airport_Entity> airport = fisServices.getairport();
        if (airport != null && !airport.isEmpty()) {
            System.out.println("The airport is fetched in the website");
            AirportResponse response = new AirportResponse(200, "All airport fetched successfully", airport);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404).body("Failed to fetch the airport");
        }
    }

    @GetMapping("/airportorigin")
    public ResponseEntity<?> getairportorigin (@RequestParam String origin) {
        List<Airport_Entity> airportorigin = fisServices.airportorigin(origin);
        if (airportorigin != null && !airportorigin.isEmpty()) {
            System.out.println("All Airport Fetched Successfully");
            AirportResponse response = new AirportResponse(200, "All airport fetched successfully", airportorigin);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404).body("Failed to fetch the airport");
        }
    }



}