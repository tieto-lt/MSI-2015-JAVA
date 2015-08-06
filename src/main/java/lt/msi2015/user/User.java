package lt.msi2015.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lt.msi2015.util.Dto;

@Entity
public class User extends Dto {

	@Id
	@GeneratedValue
	public Long id;
	
	@NotNull
	@Size(min=1, max=50)
	@Email
	public String email;
	
	@NotNull
	@Size(min=1, max=15)
	public String firstName;
	
	@NotNull
	@Size(min=1, max=15)
	public String lastName;
	
	@NotNull
	@Size(min=5)
	public String password;
	
	@NotNull
	@Past
	public Date dateCreated;

	public User() {
		// for mapping JSON -> Java
	}

	public User(Long id, String email, String firstName,
				String lastName, String password, Date dateCreated) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateCreated = dateCreated;
	}

	
}
