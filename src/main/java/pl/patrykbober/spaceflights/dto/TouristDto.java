package pl.patrykbober.spaceflights.dto;

import lombok.Data;
import pl.patrykbober.spaceflights.domain.Tourist;

import java.time.LocalDate;

@Data
public class TouristDto
{
	private Long id;
	private String firstName;
	private String lastName;
	private Tourist.Gender gender;
	private String country;
	private String remarks;
	private LocalDate dateOfBirth;

	public TouristDto()
	{
	}

	public TouristDto(Tourist tourist)
	{
		this.id = tourist.getId();
		this.firstName = tourist.getFirstName();
		this.lastName = tourist.getLastName();
		this.gender = tourist.getGender();
		this.country = tourist.getCountry();
		this.remarks = tourist.getRemarks();
		this.dateOfBirth = tourist.getDateOfBirth();
	}

	public Tourist convertToEntity()
	{
		Tourist entity = new Tourist();
		entity.setId(id);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setGender(gender);
		entity.setCountry(country);
		entity.setRemarks(remarks);
		entity.setDateOfBirth(dateOfBirth);

		return entity;
	}
}
