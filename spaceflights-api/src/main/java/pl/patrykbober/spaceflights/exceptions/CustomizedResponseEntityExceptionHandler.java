package pl.patrykbober.spaceflights.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler({NoSeatsAvailableException.class, TouristAlreadyAssignedException.class,
			TouristNotAssignedException.class, FlightAlreadyAssignedException.class,
			FlightNotAssignedException.class})
	public ResponseEntity<Object> handleAssigningExceptions(Exception e)
	{
		HttpStatus forbidden = HttpStatus.FORBIDDEN;

		ErrorDetails errorDetails = new ErrorDetails(
				e.getMessage(),
				forbidden,
				ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(errorDetails, forbidden);
	}

	@ExceptionHandler({TouristNotFoundException.class, FlightNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundExceptions(Exception e)
	{
		HttpStatus notFound = HttpStatus.NOT_FOUND;

		ErrorDetails errorDetails = new ErrorDetails(
				e.getMessage(),
				notFound,
				ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(errorDetails, notFound);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception e)
	{
		HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

		ErrorDetails errorDetails = new ErrorDetails(
				e.getMessage(),
				internalServerError,
				ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(errorDetails, internalServerError);
	}
}
