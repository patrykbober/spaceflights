package pl.patrykbober.spaceflights.dto;

import lombok.Data;
import pl.patrykbober.spaceflights.domain.Tourist;

import java.time.LocalDate;

@Data
public class TouristDto
{
	private String firstName;
	private String lastName;
	private Tourist.Gender gender = Tourist.Gender.UNKNOWN;
	private String country;
	private String remarks;
	private LocalDate dateOfBirth;

	public Tourist convertToEntity()
	{
		Tourist entity = new Tourist();
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setGender(gender);
		entity.setCountry(country);
		entity.setRemarks(remarks);
		entity.setDateOfBirth(dateOfBirth);

		return entity;
	}
}
