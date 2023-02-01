package toyproject.ottfind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toyproject.ottfind.domain.User;
import toyproject.ottfind.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findUser(Integer userId){
        return userRepository.findById(userId);
    }

    public void validateDuplicateUser(User user){
        userRepository.findByUserName(user.getUsername())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 user입니다");
                });
    }

    public Integer join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }
}
