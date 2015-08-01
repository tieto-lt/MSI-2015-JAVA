package lt.msi2015;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRest {

    static final UserList USER_LIST = new UserList(Arrays.asList(
            new User("Agnė", "a@a.lt"),
            new User("Marius", "m@m.lt"),
            new User("Onutė", "o@o.lt"),
            new User("Rimvis", "r@r.lt"),
            new User("Liepa", "l@l.lt"),
            new User("saulukas", "s@s.lt")
    ));

    @RequestMapping("/users")
    UserList users() {
        return USER_LIST;
    }

}
