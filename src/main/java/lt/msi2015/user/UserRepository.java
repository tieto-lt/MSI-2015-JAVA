package lt.msi2015.user;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    List<User> findAll();
    
    User save(User user);
}
