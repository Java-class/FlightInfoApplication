package aero.aviation.flightinfoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for Airport not found
 *
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-05-20 11:49
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AirportNotFoundException extends Exception {

    /**
     * The contractor method by code of airport
     *
     * @param airportCode airport's code
     */
    public AirportNotFoundException(String airportCode) {
        super(String.format("Airport with code:%s does not exist!", airportCode));
    }
}
