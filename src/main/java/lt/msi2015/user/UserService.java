package lt.msi2015.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User findById(Long id){
		return repo.findById(id);
	}
	
	public LoggedUserDto getCurrentUser() {
		
		 //String user = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      //String name = user.getEmail(); //get logged in username
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 
		 if (auth.getPrincipal() instanceof String) //Anonymous
			 System.out.println(auth.getPrincipal());
		 
		 org.springframework.security.core.userdetails.User userSpring = 
				 (org.springframework.security.core.userdetails.User) auth.getPrincipal(); //get logged in username
		 
	     String email = userSpring.getUsername();
	     User user = repo.findByEmail(email);
	     LoggedUserDto loggedUser = new LoggedUserDto(user.getId(), user.getFirstName(), user.getLastName(), 
	    		 			user.getEmail(), user.getRole());
	     
	     return loggedUser;
	}
}
