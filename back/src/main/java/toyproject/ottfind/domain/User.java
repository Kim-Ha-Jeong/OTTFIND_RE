package toyproject.ottfind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "user")
public class User {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @Setter
    @Column(nullable = false, length = 45)
    private String password;
}
