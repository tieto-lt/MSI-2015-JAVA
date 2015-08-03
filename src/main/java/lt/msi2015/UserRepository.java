package lt.msi2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserRepository {

    static final List<User> USER_LIST = new ArrayList<User>(Arrays.asList(
            new User("Agnė", "a@a.lt"),
            new User("Marius", "m@m.lt"),
            new User("Onutė", "o@o.lt"),
            new User("Rimvis", "r@r.lt"),
            new User("Liepa", "l@l.lt"),
            new User("saulukas", "s@s.lt")
    ));

    List<User> fetchAll() {
        return USER_LIST;	
    }
    
    User save(User user) {
    	USER_LIST.add(user);
    	return user;
    }
}
