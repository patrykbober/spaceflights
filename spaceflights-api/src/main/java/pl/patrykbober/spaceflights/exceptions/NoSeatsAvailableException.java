package pl.patrykbober.spaceflights.exceptions;

public class NoSeatsAvailableException extends RuntimeException
{
	public NoSeatsAvailableException(String message)
	{
		super(message);
	}

	public NoSeatsAvailableException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
