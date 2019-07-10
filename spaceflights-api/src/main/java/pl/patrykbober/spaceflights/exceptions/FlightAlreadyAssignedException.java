package pl.patrykbober.spaceflights.exceptions;

public class FlightAlreadyAssignedException extends RuntimeException
{
	public FlightAlreadyAssignedException(String message)
	{
		super(message);
	}

	public FlightAlreadyAssignedException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
