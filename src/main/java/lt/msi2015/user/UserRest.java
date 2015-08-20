package lt.msi2015.user;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lt.msi2015.applicationSettings.ApplicationSettingsEnum;
import lt.msi2015.applicationSettings.ApplicationSettingsService;
import lt.msi2015.shop.ShopItemDto;

@RestController
public class UserRest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	ApplicationSettingsService appSettingsService;
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<User> save(@RequestBody UserDto info) {
		
		if(userService.userExists(info)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		int monthlyLimit = appSettingsService.getSetting(ApplicationSettingsEnum.MONTHLY_LIMIT).getValue();
		
		repo.save(new User(
			info.email,
			info.firstName,
			info.lastName,
			new BCryptPasswordEncoder().encode(info.password),
			monthlyLimit
			)
		);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/user/getAllUsersFullnames", method = RequestMethod.GET)
	public List<UserAutocompleteDto> users() {
		return userService.getUsersOnly();
	}
	
	@RequestMapping(value = "/api/user/getCurrentUser", method = RequestMethod.GET)
	public @ResponseBody LoggedUserDto getCurrentUser() {
		
		return userService.getCurrentUser();
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	@ResponseBody
//	String login() {
//		System.out.println("In Login");
//		return null;
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public LoggedUserDto login() {
		return userService.getCurrentUser();
	}
	
	@RequestMapping(value = "/email/check", method = RequestMethod.GET)
	public boolean emailExists(@RequestParam(value="email") String email) {
		return userService.emailExists(email);
	}
	
	@RequestMapping(value = "/api/user/profile", method = RequestMethod.GET)
	public @ResponseBody UserProfileDto getUserProfile(@RequestParam(value="id") Long id) {
		
		return userService.getUserProfile(id);
	}
	
	@RequestMapping(value = "api/user/profile", method = RequestMethod.POST) 
	ResponseEntity<?> updateShopItem (@RequestBody UserProfileDto userProfile){
		if (userService.updateUserProfile(userProfile)) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
}
