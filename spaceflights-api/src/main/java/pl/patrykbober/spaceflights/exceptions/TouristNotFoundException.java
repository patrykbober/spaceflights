package pl.patrykbober.spaceflights.exceptions;

public class TouristNotFoundException extends RuntimeException
{
	public TouristNotFoundException(String message)
	{
		super(message);
	}

	public TouristNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
