package lt.msi2015.user;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lt.msi2015.util.Dto;

public class LoggedUserDto extends Dto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Role role;
	private Integer pointsToGive;
	private Integer userPoints;
	
	public LoggedUserDto() {
		super();
	}
	
	public LoggedUserDto(Long id,String firstName, String lastName, String email, Role role,
						Integer pointsToGive, Integer userPoints) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.id = id;
		this.pointsToGive = pointsToGive;
		this.userPoints = userPoints;
	}

	public Integer getPointsToGive() {
		return pointsToGive;
	}

	public Integer getUserPoints() {
		return userPoints;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Role getRole() {
		return role;
	}

	public Long getId() {
		return id;
	}


	
}
