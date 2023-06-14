package aero.aviation.flightinfoapplication.data.dao;

import aero.aviation.flightinfoapplication.data.entity.FlightEntity;
import aero.aviation.flightinfoapplication.data.enumeration.CargoType;
import aero.aviation.flightinfoapplication.data.enumeration.FlightType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 22:16
 */
@Repository
public interface FlightRepository extends CrudRepository<FlightEntity, String> {
    @Query(value = "select count(*) from FlightEntity " +
            "where sourceAirport.code= :airportCode " +
            "and flightDate=:flightDate " +
            "and ((:flightType IS NOT NULL AND flightType =:flightType ) OR :flightType IS NULL)")
    Long getAirportFlightCount(@Param("airportCode") String flightNumber,
                               @Param("flightDate") Date flightDate,
                               @Param("flightType") FlightType flightType);

    Optional<FlightEntity> getByFlightNumber(String flightNumber);
}
