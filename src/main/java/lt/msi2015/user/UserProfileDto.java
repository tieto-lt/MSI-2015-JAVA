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
	private String oldPassword;
	private String newPassword;
	
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



	public UserProfileDto(String firstName, String lastName, String email, String aboutMe, byte[] image,
			String imageName, String imageType, String oldPassword, String newPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.aboutMe = aboutMe;
		this.image = image;
		this.imageName = imageName;
		this.imageType = imageType;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getUserPoints() {
		return userPoints;
	}



	public void setUserPoints(Integer userPoints) {
		this.userPoints = userPoints;
	}



	public Integer getRank() {
		return rank;
	}



	public void setRank(Integer rank) {
		this.rank = rank;
	}



	public String getAboutMe() {
		return aboutMe;
	}



	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



	public String getImageType() {
		return imageType;
	}



	public void setImageType(String imageType) {
		this.imageType = imageType;
	}



	public String getOldPassword() {
		return oldPassword;
	}



	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}



	public String getNewPassword() {
		return newPassword;
	}



	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}




}
