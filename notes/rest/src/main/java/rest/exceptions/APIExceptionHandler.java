package rest.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

/**
 * Exception shown when API error occurs.
 */
public class APIExceptionHandler {

  private final String message;
  private final int status;
  private final HttpStatus httpStatus;
  
  /**
   * Api error message including following.
   *
   * @param message a message
   * @param status the status
   * @param httpStatus the http status
   * @param timestamp a timestamp
   */
  public APIExceptionHandler(String message, int status, HttpStatus httpStatus) {
    this.message = message;
    this.status = status;
    this.httpStatus = httpStatus;
  } 

  public String getMessage() {
    return message;
  }

  public int getStatus() {
    return status;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }


}