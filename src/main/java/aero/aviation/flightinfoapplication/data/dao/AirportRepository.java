package aero.aviation.flightinfoapplication.data.dao;

import aero.aviation.flightinfoapplication.data.entity.AirportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 22:15
 */
@Repository
public interface AirportRepository extends CrudRepository<AirportEntity, String> {

    Optional<AirportEntity> getByCode(String airportCode);
}
