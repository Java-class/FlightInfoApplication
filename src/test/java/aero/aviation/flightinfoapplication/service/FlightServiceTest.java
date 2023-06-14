package aero.aviation.flightinfoapplication.service;

import aero.aviation.flightinfoapplication.controller.dto.request.FlightType;
import aero.aviation.flightinfoapplication.exception.AirportNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-14 19:00
 */
class FlightServiceTest extends BaseIT {

    @Autowired
    private FlightService flightService;

    @Test
    @Order(1)
    void getAirportFlightCountTest() throws AirportNotFoundException {
        flightService.getAirportFlightCount("ARP1", "2023-06-13T08:00:00", FlightType.TOTAL);
    }

    @Test
    @Order(2)
    void notFundAirportFlightCountTest() {
        assertThrows(AirportNotFoundException.class, () -> {
            flightService.getAirportFlightCount("NotFoundAirportCode", "2023-06-13T08:00:00", FlightType.TOTAL);
        });
    }
}