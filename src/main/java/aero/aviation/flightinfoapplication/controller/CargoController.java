package aero.aviation.flightinfoapplication.controller;

import aero.aviation.flightinfoapplication.controller.dto.request.WeightSumType;
import aero.aviation.flightinfoapplication.exception.FlightNotFoundException;
import aero.aviation.flightinfoapplication.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 23:24
 */
@RestController
@RequestMapping(path = "/api/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @GetMapping(path = "/weight")
    public long getCargoWeightSum(@RequestParam("flightNumber") String flightNumber,
                                  @RequestParam("flightDate") String flightDate,
                                  @RequestParam("sumType") WeightSumType sumType) throws FlightNotFoundException {
        return cargoService.getCargoWeightSum(flightNumber, flightDate, sumType);
    }
}
