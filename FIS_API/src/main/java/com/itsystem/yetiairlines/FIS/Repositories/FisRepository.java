package com.itsystem.yetiairlines.FIS.Repositories;


import com.itsystem.yetiairlines.FIS.Entity.FIS_Entity;
import com.itsystem.yetiairlines.FIS.Entity.FisRemarks_Entity;
import com.itsystem.yetiairlines.FIS.Entity.FisStatus_Entity;
import com.itsystem.yetiairlines.FIS.Entity.Result_Entity;
import com.itsystem.yetiairlines.FIS.Entity.Edit_Entity;
import com.itsystem.yetiairlines.FIS.Entity.Airport_Entity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface FisRepository extends JpaRepository<FIS_Entity, String> {

    @Query(value = "EXEC uspDisplayFlightInfo_umn :from ,:to, 'website';", nativeQuery = true)
    List<FIS_Entity>flightstatus(@Param("from") String from,
                                 @Param("to") String to);

    @Query(value = "EXEC uspDisplayFlightInfo_umn :airport,:ArrivalAirport,'Schedule';",nativeQuery = true)
    List<FIS_Entity>getschedule(@Param("airport") String airport,
                                @Param("ArrivalAirport") String ArrivalAirport);

    @Query(value = "EXEC uspDisplayFlightInfo_umn :airport,'','preview';",nativeQuery = true)
    List<FIS_Entity>preview(@Param("airport") String airport);


    @Transactional
    @Query(value = "EXEC uspUpdateFlightStatusInformation_umn :Revised_Time, :FlightStatus ,:FlightStatus_Remarks, :userid, :flightNumber, :hide, :FlightStatus_Time ",nativeQuery = true)
    Result_Entity updateresult(@Param("flightNumber") String flightNumber,
                               @Param("Revised_Time") String Revised_Time,
                               @Param("FlightStatus") String FlightStatus,
                               @Param("FlightStatus_Remarks") String FlightStatus_Remarks,
                               @Param("userid") String userid,
                               @Param("hide") int hide,
                               @Param("FlightStatus_Time") String FlightStatus_Time);

    @Query(value = "select * from FISFlightStatus",nativeQuery = true)
      List<FisStatus_Entity> getstatus();

    @Query(value = "select * from FISFlightRemarks",nativeQuery = true)
    List<FisRemarks_Entity> getremarks();

    @Query(value = "select flightNumber,Departure_Time, FlightStatus, Revised_Time, FlightStatus_Time,FlightStatus_Remarks,ISNULL(Hide,0)AS Hide from FlightStatusInformation where Departure_Date  = CAST(GETDATE() AS DATE) and flightNumber = :flightNumber",nativeQuery = true)
    Edit_Entity edit (@Param("flightNumber") String flightNumber);

    @Query(value = "EXEC uspGetAirports",nativeQuery = true)
    List<Airport_Entity> getairport();


    @Query(value = "EXEC uspGetAirports :origin ",nativeQuery = true)
    List<Airport_Entity> getairportorigin (@Param("origin") String origin);
}
