package lt.msi2015.user;

import lt.msi2015.util.Dto;

public class UserAutocompleteDto extends Dto {
	public long id;
	public String firstName;
	public String lastName;
	
	public UserAutocompleteDto() {
		super();
	}

	public UserAutocompleteDto(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
