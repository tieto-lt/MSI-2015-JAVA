package lt.msi2015.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
 
    /*Optional<User> findOneByEmail(String email);*/
    User findByEmail(String email);
    
    User findById(Long id);
}
