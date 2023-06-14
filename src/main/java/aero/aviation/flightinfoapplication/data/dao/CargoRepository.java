package aero.aviation.flightinfoapplication.data.dao;

import aero.aviation.flightinfoapplication.data.entity.CargoEntity;
import aero.aviation.flightinfoapplication.data.enumeration.CargoType;
import aero.aviation.flightinfoapplication.data.enumeration.FlightType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 22:17
 */
@Repository
public interface CargoRepository extends CrudRepository<CargoEntity, String> {
    @Query(value = "select sum(weight) from CargoEntity " +
            "where flight.id= :flightId " +
            "and flight.flightDate= :flightDate " +
            "and ((:cargoType IS NOT NULL AND cargoType =:cargoType ) OR :cargoType IS NULL)")
    Long getSumCargoWeight(@Param("flightId") String flightId,
                           @Param("flightDate") Date flightDate,
                           @Param("cargoType") CargoType cargoType);


    @Query(value = "select count(*) from CargoEntity " +
            "where flight.sourceAirport.code= :airportCode " +
            "and flight.flightDate=:flightDate " +
            "and ((:cargoType IS NOT NULL AND cargoType =:cargoType ) OR :cargoType IS NULL) " +
            "and ((:flightType IS NOT NULL AND flight.flightType =:flightType ) OR :flightType IS NULL)")
    Long getAirportCargoCount(@Param("airportCode") String airportCode,
                              @Param("flightDate") Date flightDate,
                              @Param("flightType") FlightType flightType,
                              @Param("cargoType") CargoType cargoType);
}
