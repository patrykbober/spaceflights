package pl.patrykbober.spaceflights.exceptions;

public class TouristNotAssignedException extends RuntimeException
{
	public TouristNotAssignedException(String message)
	{
		super(message);
	}

	public TouristNotAssignedException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
