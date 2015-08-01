package lt.msi2015;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRest {
	
	@RequestMapping("/users")
    String users() {
        return "{"
                + "  \"users\": ["
                + "    {"
                + "      \"name\": \"Marius\","
                + "      \"email\": \"m@m.lt\""
                + "    },"
                + "    {"
                + "      \"name\": \"Rimvis\","
                + "      \"email\": \"r@r.lt\""
                + "    },"
                + "    {"
                + "      \"name\": \"saulukas\","
                + "      \"email\": \"s@s.lt\""
                + "    },"
                + "    {"
                + "      \"name\": \"Agnė\","
                + "      \"email\": \"a@a.lt\""
                + "    }"
                + "  ]"
                + "}";
    }

}
