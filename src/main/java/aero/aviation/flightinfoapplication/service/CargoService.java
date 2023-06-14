package aero.aviation.flightinfoapplication.service;

import aero.aviation.flightinfoapplication.controller.dto.request.CargoFilterType;
import aero.aviation.flightinfoapplication.controller.dto.request.FlightType;
import aero.aviation.flightinfoapplication.controller.dto.request.WeightSumType;
import aero.aviation.flightinfoapplication.data.dao.CargoRepository;
import aero.aviation.flightinfoapplication.data.dao.FlightRepository;
import aero.aviation.flightinfoapplication.data.entity.AirportEntity;
import aero.aviation.flightinfoapplication.data.entity.FlightEntity;
import aero.aviation.flightinfoapplication.data.enumeration.CargoType;
import aero.aviation.flightinfoapplication.exception.AirportNotFoundException;
import aero.aviation.flightinfoapplication.exception.FlightNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

/**
 * This class calculates cargo's weight and counts for specific flight
 *
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 23:12
 */
@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    private final FlightRepository flightRepository;

    /**
     * Get Cargo, Baggage or total weight sum
     *
     * @param flightNumber mandatory flight number
     * @param flightDate   mandatory flight's date
     * @return long sum of cargo weight
     */
    public long getCargoWeightSum(String flightNumber, String flightDate, WeightSumType weightSumType) throws FlightNotFoundException {
        CargoType cargoType = null;
        switch (weightSumType) {
            case CARGO -> cargoType = CargoType.CARGO;
            case BAGGAGE -> cargoType = CargoType.BAGGAGE;
        }
        LocalDateTime dateTime = LocalDateTime.parse(flightDate);
        Date date = java.util.Date
                .from(dateTime.atZone(ZoneId.systemDefault())
                        .toInstant());
        Optional<FlightEntity> optionalFlight = flightRepository.getByFlightNumber(flightNumber);
        FlightEntity flightEntity = optionalFlight.orElseThrow(() -> new FlightNotFoundException(flightNumber));
        Long sum = cargoRepository.getSumCargoWeight(flightEntity.getId(), date, cargoType);
        if (sum == null) {
            return -1;
        } else return sum;
    }

    /**
     * Get Cargo, Baggage or total airport count
     *
     * @param airportCode     mandatory airport number
     * @param flightDate      mandatory flight's date
     * @param flightType      type of flight
     * @param cargoFilterType type of cargo
     * @return long count of cargo
     */
    public long getAirportCargoCount(String airportCode, String flightDate, FlightType flightType, CargoFilterType cargoFilterType) {
        Long count = -1L;
        aero.aviation.flightinfoapplication.data.enumeration.FlightType type = null;
        switch (flightType) {
            case ARRIVING -> type = aero.aviation.flightinfoapplication.data.enumeration.FlightType.ARRIVING;
            case DEPARTING -> type = aero.aviation.flightinfoapplication.data.enumeration.FlightType.DEPARTING;
        }
        CargoType cargoType = null;
        switch (cargoFilterType) {
            case BAGGAGE -> cargoType = CargoType.BAGGAGE;
            case CARGO -> cargoType = CargoType.CARGO;
        }
        LocalDateTime dateTime = LocalDateTime.parse(flightDate);
        Date date = java.util.Date
                .from(dateTime.atZone(ZoneId.systemDefault())
                        .toInstant());
        count = cargoRepository.getAirportCargoCount(airportCode, date, type, cargoType);
        return count;
    }
}
