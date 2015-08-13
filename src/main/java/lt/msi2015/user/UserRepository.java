package lt.msi2015.user;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    List<User> findAll();
    
//    List<User> saveAll(List<User> updatedUsers);
    
    /*Optional<User> findOneByEmail(String email);*/
    User findByEmail(String email);
    
    User findById(Long id);
    
    User save(User user);
}
