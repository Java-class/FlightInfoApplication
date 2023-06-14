package aero.aviation.flightinfoapplication.service;

import aero.aviation.flightinfoapplication.controller.dto.request.CargoFilterType;
import aero.aviation.flightinfoapplication.controller.dto.request.FlightType;
import aero.aviation.flightinfoapplication.controller.dto.request.WeightSumType;
import aero.aviation.flightinfoapplication.exception.AirportNotFoundException;
import aero.aviation.flightinfoapplication.exception.FlightNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-14 22:38
 */
class CargoServiceTest extends BaseIT {

    @Autowired
    private CargoService cargoService;

    @Test
    @Order(1)
    void getCargoWeightSum() throws FlightNotFoundException {
        cargoService.getCargoWeightSum("FLA1A-0A06", "2023-06-13T08:00:00", WeightSumType.CARGO);
    }

    @Test
    @Order(2)
    void getAirportCargoCount() {
        cargoService.getAirportCargoCount("ARP1", "2023-06-13T08:00:00", FlightType.TOTAL, CargoFilterType.TOTAL);
    }

    @Test
    @Order(1)
    void getCargoWeightSumNotFound()  {
        assertThrows(FlightNotFoundException.class, () -> {
            cargoService.getCargoWeightSum("NotFoundFlight", "2023-06-13T08:00:00", WeightSumType.CARGO);
        });
    }
}