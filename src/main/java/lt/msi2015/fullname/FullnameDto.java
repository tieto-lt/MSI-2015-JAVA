package lt.msi2015.fullname;

import lt.msi2015.util.Dto;

public class FullnameDto extends Dto {
	public long id;
	public String firstName;
	public String lastName;
	
	public FullnameDto() {
		super();
	}

	public FullnameDto(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
