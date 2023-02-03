package toyproject.ottfind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "genre")
public class Genre {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
}
