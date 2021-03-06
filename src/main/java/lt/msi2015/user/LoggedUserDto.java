package lt.msi2015.user;

import lt.msi2015.util.Dto;

public class LoggedUserDto extends Dto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Role role;
	private Integer pointsToGive;
	private Integer userPoints;
	private byte[] image;
	
	public LoggedUserDto() {
		super();
	}
	
	public LoggedUserDto(Long id,String firstName, String lastName, String email, Role role,
						Integer pointsToGive, Integer userPoints, byte[] image) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.id = id;
		this.pointsToGive = pointsToGive;
		this.userPoints = userPoints;
		this.image = image;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
	
}
