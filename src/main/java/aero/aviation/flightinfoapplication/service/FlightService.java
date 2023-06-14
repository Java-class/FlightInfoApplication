package aero.aviation.flightinfoapplication.service;

import aero.aviation.flightinfoapplication.controller.dto.request.FlightType;
import aero.aviation.flightinfoapplication.data.dao.AirportRepository;
import aero.aviation.flightinfoapplication.data.dao.FlightRepository;
import aero.aviation.flightinfoapplication.data.entity.AirportEntity;
import aero.aviation.flightinfoapplication.exception.AirportNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

/**
 * This class calculates the airport's flight count
 *
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-13 22:14
 */
@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private final AirportRepository airportRepository;

    /**
     * Get Cargo, Baggage or total airport count
     *
     * @param airportCode mandatory airport number
     * @param flightDate  mandatory flight's date
     * @param flightType  type of flight
     * @return long count of airport's flight
     */
    public long getAirportFlightCount(String airportCode, String flightDate, FlightType flightType) throws AirportNotFoundException {
        Long count = -1L;
        aero.aviation.flightinfoapplication.data.enumeration.FlightType type = null;
        switch (flightType) {
            case ARRIVING -> type = aero.aviation.flightinfoapplication.data.enumeration.FlightType.ARRIVING;
            case DEPARTING -> type = aero.aviation.flightinfoapplication.data.enumeration.FlightType.DEPARTING;
        }
        LocalDateTime dateTime = LocalDateTime.parse(flightDate);
        Date date = java.util.Date
                .from(dateTime.atZone(ZoneId.systemDefault())
                        .toInstant());
        Optional<AirportEntity> optionalAirport = airportRepository.getByCode(airportCode);
        AirportEntity airportEntity = optionalAirport.orElseThrow(() -> new AirportNotFoundException(airportCode));
        count = flightRepository.getAirportFlightCount(airportEntity.getCode(), date, type);
        return count;
    }
}
