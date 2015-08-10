package lt.msi2015.fullname;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@RestController
public class FullnameRest {

	@Autowired
	UserRepository repo;

	@RequestMapping(value = "/user/fullnames", method = RequestMethod.GET)
	public List<FullnameDto> users() {
		List<User> userList = repo.findAll();
		
		List<FullnameDto> namesList = new ArrayList<> ();

		for (User u: userList) {
			namesList.add(new FullnameDto(u.id, u.firstName, u.lastName));
		}
		
		return namesList;
	}
}
