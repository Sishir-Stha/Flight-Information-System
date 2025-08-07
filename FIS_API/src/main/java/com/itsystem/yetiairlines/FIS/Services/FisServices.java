package com.itsystem.yetiairlines.FIS.Services;


import com.itsystem.yetiairlines.FIS.Entity.FIS_Entity;
import com.itsystem.yetiairlines.FIS.Entity.FisRemarks_Entity;
import com.itsystem.yetiairlines.FIS.Entity.FisStatus_Entity;
import com.itsystem.yetiairlines.FIS.Entity.Result_Entity;
import com.itsystem.yetiairlines.FIS.Repositories.FisRepository;
import com.itsystem.yetiairlines.FIS.Entity.Edit_Entity;
import com.itsystem.yetiairlines.FIS.Entity.Airport_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class FisServices {
    @Autowired
    public FisRepository fisRepository;

    public List<FIS_Entity> flightstatus(String from , String to ){
        return fisRepository.flightstatus(from, to);
    }

    public List<FIS_Entity>getschedule(String airport, String ArrivalAirport){
        return fisRepository.getschedule(airport, ArrivalAirport);
    }
    public List<FIS_Entity>preview(String airport){
        return fisRepository.preview(airport);
    }


    public boolean update(String flightNumber,String Revised_Time, String FlightStatus,String FlightStatus_Remarks, String userid, int hide, String FlightStatus_Time){
        try {
            Result_Entity result = fisRepository.updateresult(flightNumber, Revised_Time, FlightStatus, FlightStatus_Remarks, userid, hide, FlightStatus_Time);
            int value = result.getResult();
            if (value == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error updating Status: " + e.getMessage());
            return false;
        }
    }

//    public  List<> getschedule(){
//        try{
//            return fisRepository.getschedule();
//        }catch(Exception e){
//            throw  new RuntimeException(e);
//        }
//    }

    public List<FisRemarks_Entity> getremarks(){
        try{
            return fisRepository.getremarks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<FisStatus_Entity> getstatus(){
        try{
            return fisRepository.getstatus();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Airport_Entity> getairport(){
        try{
            return fisRepository.getairport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

public List<Airport_Entity> airportorigin(String origin){
    try {
        return fisRepository.getairportorigin(origin);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}


public Edit_Entity edit(String flightNumber) {
        try {
            return fisRepository.edit(flightNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
