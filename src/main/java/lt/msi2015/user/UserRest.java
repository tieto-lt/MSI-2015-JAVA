package lt.msi2015.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRest {

	@Autowired
	UserRepository repo;
	
	//FROM SKELETON
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	List<User> users() {
		return repo.findAll();
	}

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	@ResponseBody
	User save(@RequestBody UserDto info) {
		return repo.save(new User(info.email, info.firstName, info.lastName, info.password));
	}

}
