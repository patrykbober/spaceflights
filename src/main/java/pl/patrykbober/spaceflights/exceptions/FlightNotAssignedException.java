package pl.patrykbober.spaceflights.exceptions;

public class FlightNotAssignedException extends RuntimeException
{
	public FlightNotAssignedException(String message)
	{
		super(message);
	}

	public FlightNotAssignedException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
