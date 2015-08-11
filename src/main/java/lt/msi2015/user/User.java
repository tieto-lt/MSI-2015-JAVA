package lt.msi2015.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lt.msi2015.util.Dto;

@Entity
public class User extends Dto {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min=1, max=50)
	@Email
	private String email;
	
	@NotNull
	@Size(min=1, max=15)
	private String firstName;
	
	@NotNull
	@Size(min=1, max=15)
	private String lastName;
	
	@NotNull
	@Size(min=5)
	private String password;
	
	@NotNull
	@Past
	private Date dateCreated;
	
	@NotNull
	@Column(columnDefinition = "int default 0")
	private Integer pointsToGive;
	
	@NotNull
	@Column(columnDefinition = "int default 0")
	private Integer userPoints;
	
//	@NotNull
//	private Boolean isAdmin;

	public Role role = Role.USER;

	/*
	 * For mapping JSON -> Java
	 */
	public User() {
		
	}

	/*
	 * If creating ordinary user
	 */
	public User(String email, String firstName,
				String lastName, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateCreated = new Date();
	}

	/*
	 * If creating admin user
	 */
	/*public User(String email, String firstName,
			String lastName, String password, Boolean isAdmin) {
		this(email, firstName, lastName, password);
		this.isAdmin = isAdmin;
	}	
	
	/*
	 * Getters and setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Role getRole() {
		return role;
	}

//	public Boolean getIsAdmin() {
//		return isAdmin;
//	}
//
//	public void setIsAdmin(Boolean isAdmin) {
//		this.isAdmin = isAdmin;
//	}	
}
