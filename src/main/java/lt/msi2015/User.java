package lt.msi2015;

public class User extends Dto {

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
