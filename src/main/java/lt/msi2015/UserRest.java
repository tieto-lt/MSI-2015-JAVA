package lt.msi2015;

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

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	List<User> users() {
		return repo.findAll();
	}

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	@ResponseBody
	User save(@RequestBody User user) {
		return repo.save(user);
	}

}
