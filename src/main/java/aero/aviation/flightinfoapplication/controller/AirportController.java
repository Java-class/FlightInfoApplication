package aero.aviation.flightinfoapplication.controller;

import aero.aviation.flightinfoapplication.controller.dto.request.CargoFilterType;
import aero.aviation.flightinfoapplication.controller.dto.request.FlightType;
import aero.aviation.flightinfoapplication.data.enumeration.CargoType;
import aero.aviation.flightinfoapplication.exception.AirportNotFoundException;
import aero.aviation.flightinfoapplication.service.CargoService;
import aero.aviation.flightinfoapplication.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-13 22:13
 */
@RestController
@RequestMapping(path = "/api/airport")
@RequiredArgsConstructor
public class AirportController {

    private final FlightService flightService;

    private final CargoService cargoService;

    @GetMapping(path = "/flightCount")
    public long getAirportFlightCount(@RequestParam("airportCode") String airportCode,
                                      @RequestParam("flightDate") String flightDate,
                                      @RequestParam("flightType") FlightType flightType) throws AirportNotFoundException {
        return flightService.getAirportFlightCount(airportCode, flightDate, flightType);
    }

    @GetMapping(path = "/cargoCount")
    public long getAirportCargoCount(@RequestParam("airportCode") String airportCode,
                                     @RequestParam("flightDate") String flightDate,
                                     @RequestParam("flightType") FlightType flightType,
                                     @RequestParam("cargoType") CargoFilterType cargoFilterType) {
        return cargoService.getAirportCargoCount(airportCode, flightDate, flightType, cargoFilterType);
    }
}
