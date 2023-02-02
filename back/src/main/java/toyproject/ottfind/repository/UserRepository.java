package toyproject.ottfind.repository;

import org.springframework.stereotype.Repository;
import toyproject.ottfind.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends GeneralRepository<User>{
    Optional<User> findByUserName(String username);
}
