package lt.msi2015.user;

import lt.msi2015.util.Dto;

public class UserDto extends Dto {
	
	public String email;
	public String firstName;
	public String lastName;
	public String password;
	public String passwordConfirm;
	//private Role role = Role.USER;
	
	public UserDto() {
		super();
	}


	public UserDto(String email, String firstName, String lastName, String password, String passwordConfirm) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

}
