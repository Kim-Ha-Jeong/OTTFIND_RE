package toyproject.ottfind.repository;

import org.springframework.stereotype.Repository;
import toyproject.ottfind.domain.User;

import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User> {
    Optional<User> findByUserName(String username);
}
