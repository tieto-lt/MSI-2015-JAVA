package lt.msi2015;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User extends Dto {

	@Id
	@GeneratedValue
	public Long id;
	public String name;
	public String email;

	public User() {
		// for mapping JSON -> Java
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

}
