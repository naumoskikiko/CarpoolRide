package carPoolRide.carPoolRide.exceptionhandleclass;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPassengerOperationException extends RuntimeException {
    public InvalidPassengerOperationException(String message) {
        super(message);
    }
}