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
import org.springframework.beans.factory.annotation.Value;

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
	
	public Role role = Role.USER;

	/*@NotNull
	public Boolean isAdmin;*/


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
	}*/	
}
