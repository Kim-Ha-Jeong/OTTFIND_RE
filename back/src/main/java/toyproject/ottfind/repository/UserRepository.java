package toyproject.ottfind.repository;

import org.springframework.stereotype.Repository;
import toyproject.ottfind.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    User save(User user);
    Optional<User> findById(Integer id);
    Optional<User> findByUserName(String username);
    List<User> findAll();
}
