package toyproject.ottfind.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toyproject.ottfind.domain.User;
import toyproject.ottfind.repository.UserInterface;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserInterface userRepository;

    @Test
    void 회원가입() throws Exception{
        User user = new User();
        user.setUsername("김하정");
        user.setPassword("12345");

        Integer id = userService.join(user);

        User findUser = userRepository.findById(id).get();
        assertEquals(user.getUsername(), findUser.getUsername());
    }


    @Test
    void 중복가입() throws Exception{
        User user1 = new User();
        user1.setUsername("spring");
        user1.setPassword("1234");
        User user2 = new User();
        user2.setUsername("spring");
        user2.setPassword("4567");

        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> userService.join(user2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 user입니다");
    }
    
    @Test
    void 모든_user_조회() throws Exception {
        List<User> userList = userService.getAllUser();
        
        for(User u : userList){
            System.out.println("name = " + u.getUsername());
        }

        assertThat(userList.size()).isEqualTo(4);
    }

}