package pl.patrykbober.spaceflights.exceptions;

public class TouristAlreadyAssignedException extends RuntimeException
{
	public TouristAlreadyAssignedException(String message)
	{
		super(message);
	}

	public TouristAlreadyAssignedException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
