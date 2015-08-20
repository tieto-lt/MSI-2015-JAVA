package lt.msi2015.user;

import lt.msi2015.util.Dto;

public class UserProfileDto extends Dto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Integer userPoints;
	private Integer rank;
	private String aboutMe;
	private byte[] image;
	private String imageName;
	private String imageType;
	
	public UserProfileDto() {
		super();
	}

	public UserProfileDto(Long id, String firstName, String lastName, String email, Integer userPoints, Integer rank,
			String aboutMe, byte[] image, String imageName, String imageType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userPoints = userPoints;
		this.rank = rank;
		this.aboutMe = aboutMe;
		this.image = image;
		this.imageName = imageName;
		this.imageType = imageType;
	}

	public Long getId() {
		return id;
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

	public Integer getUserPoints() {
		return userPoints;
	}

	public Integer getRank() {
		return rank;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public byte[] getImage() {
		return image;
	}

	public String getImageName() {
		return imageName;
	}

	public String getImageType() {
		return imageType;
	}

}
