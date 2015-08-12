package lt.msi2015.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lt.msi2015.pointsTransferInfo.PointsTransferInfoService;

@RestController
public class UserRest {

	@Autowired
	UserService service;
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	@ResponseBody
	User save(@RequestBody UserDto info) {
		return repo.save(new User(info.email, info.firstName, info.lastName, info.password));
	}
	
	@RequestMapping(value = "/user/getAllUsersFullnames", method = RequestMethod.GET)
	public List<UserAutocompleteDto> users() {
		List<User> userList = repo.findAll();
		
		List<UserAutocompleteDto> namesList = new ArrayList<> ();

		for (User u: userList) {
			namesList.add(new UserAutocompleteDto(u.getId(), u.getFirstName(), u.getLastName()));
		}
		
		return namesList;
	}
	
	@RequestMapping(value = "/user/getCurrentUser", method = RequestMethod.GET)
	public @ResponseBody LoggedUserDto getCurrentUser() {
		
		return service.getCurrentUser();
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	@ResponseBody
//	String login() {
//		System.out.println("In Login");
//		return null;
//	}
	@RequestMapping("/login")
	  public Principal login(Principal user) {
		return user;
	  }

}
