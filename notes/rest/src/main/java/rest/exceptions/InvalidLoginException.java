package rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for when user is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid login")
public class InvalidLoginException extends RuntimeException {

    public InvalidLoginException(String message) {
        super(message);
    }

    public InvalidLoginException() {
        super("Invalid login");
    }

}
