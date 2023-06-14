package aero.aviation.flightinfoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for flight not found
 *
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-05-20 11:49
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlightNotFoundException extends Exception {

    /**
     * The contractor method by number of flights
     *
     * @param flightNumber flight's number
     */
    public FlightNotFoundException(String flightNumber) {
        super(String.format("Flight with number:%s does not exist!", flightNumber));
    }
}
