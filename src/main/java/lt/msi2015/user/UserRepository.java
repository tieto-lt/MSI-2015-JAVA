package lt.msi2015.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    List<User> findAll();
    
    /*Optional<User> findOneByEmail(String email);*/
    User findByEmail(String email);
    
    User save(User user);
}
