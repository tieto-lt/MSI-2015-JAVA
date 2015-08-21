package lt.msi2015.user;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lt.msi2015.applicationSettings.ApplicationSetting;
import lt.msi2015.applicationSettings.ApplicationSettingsEnum;
import lt.msi2015.applicationSettings.ApplicationSettingsRepository;
import lt.msi2015.leaderboard.LeaderboardService;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	ApplicationSettingsRepository appSettingsRepo;
	
	@Autowired
	LeaderboardService leaderboardService;
	
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
	
	public boolean emailExists(String email) {
		User user = repo.findByEmail(email);
		if(user != null) {
			return true;
		}
		return false;
	}
	
	
	/*
	 * Quartz monthly points_to_give reset to application_settings value
	 */
	@Scheduled(cron = "1 0 0 1 * *")
	@Transactional
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
	
	@Transactional
	public List<UserAutocompleteDto> getUsersOnly() {
		
		List<User> userList = repo.findAll();
		List<UserAutocompleteDto> namesList = new ArrayList<> ();

		for (User u: userList) {
			if(u.getRole().name() == "USER") {
				namesList.add(new UserAutocompleteDto(u.getId(), u.getFirstName(), u.getLastName()));
			}
		}
		return namesList;
	}
	
	public UserProfileDto getUserProfile(Long id) {
		
		User user = repo.findById(id);
		
		Integer userRank = leaderboardService.getUserRank(id);
		
		UserProfileDto userProfile = new UserProfileDto(user.getId(), user.getFirstName(),
				user.getLastName(), user.getEmail(), user.getUserPoints(), userRank, user.getAboutMe(), 
				user.getImage(), user.getImageName(), user.getImageType());
		
		return userProfile;
	}
	
	@Transactional
	boolean updateUserProfile(UserProfileDto userProfile) {
		if (!dataIsValid(userProfile)) {
			return false;
		}
		
		return updateProfileIfo(userProfile);
	}
	
	public boolean dataIsValid(UserProfileDto dto) {
		return imageIsValid(dto.getImageType()) && passwordIsValid(dto);
	}
	
	private boolean passwordIsValid(UserProfileDto dto) {
		return matchesOldPassword(dto);
	}

	private boolean matchesOldPassword(UserProfileDto dto) {
		User user = repo.findById(dto.getId());
		String passString = dto.getOldPassword();
		return BCrypt.checkpw(passString, user.getPassword());
	}

	private boolean updateProfileIfo(UserProfileDto userProfileEdited) {
		
		User userInDatabase = repo.findById(userProfileEdited.getId());
		String passHash = new BCryptPasswordEncoder().encode(userProfileEdited.getNewPassword());
		
		if(userInDatabase != null) {
			userInDatabase.setFirstName(userProfileEdited.getFirstName());
			userInDatabase.setLastName(userProfileEdited.getLastName());
			userInDatabase.setAboutMe(userProfileEdited.getAboutMe());
			userInDatabase.setImage(userProfileEdited.getImage());
			userInDatabase.setImageName(userProfileEdited.getImageName());
			userInDatabase.setImageType(userProfileEdited.getImageType());
			userInDatabase.setPassword(passHash);
			return repo.save(userInDatabase) != null;
		}
		return false;
	}
	
	private boolean imageIsValid(String type){
		return (type.equals("image/jpeg")) || (type.equals("image/png")) || (type.equals("image/gif"));
	}
}
