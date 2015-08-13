package lt.msi2015.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lt.msi2015.applicationSettings.ApplicationSetting;
import lt.msi2015.applicationSettings.ApplicationSettingsEnum;
import lt.msi2015.applicationSettings.ApplicationSettingsRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	ApplicationSettingsRepository appSettingsRepo;

	
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
	    		 			user.getEmail(), user.getRole(), user.getPointsToGive(),
	    		 			user.getUserPoints());
	     
	     return loggedUser;
	}

	public boolean userExists(UserDto info) {

		User user = repo.findByEmail(info.email);
		if(user != null) {
			return true;
		}
		return false;
	}
	
	
	/*
	 * Quartz monthly points_to_give reset to application_settings value
	 */
	@Scheduled(cron = "1 0 0 1 * *")
	public void resetUserPointsToGiveEachMonth() {
		//System.out.println("Ivyko: " + new Date());
	
		final ApplicationSetting monthlyLimit = 
				appSettingsRepo.findByProperty(ApplicationSettingsEnum.MONTHLY_LIMIT.toString());
		
		List<User> userList = repo.findAll();
		
		for (User u: userList) {
			u.setPointsToGive(monthlyLimit.getValue());
			//System.out.println(u.getPointsToGive());
			repo.save(u);
		}
	}
}
