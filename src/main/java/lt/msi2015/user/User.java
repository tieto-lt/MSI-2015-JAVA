package lt.msi2015.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lt.msi2015.util.Dto;

@Entity
public class User extends Dto {

	@Id
	@GeneratedValue
	public Long id;
	public String name;
	
	@Size(min=3, max=24)
	public String email;

	public User() {
		// for mapping JSON -> Java
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

}
