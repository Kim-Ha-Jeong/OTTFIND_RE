package toyproject.ottfind.domain;

import lombok.Setter;

import javax.persistence.*;

@Entity(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(nullable = false)
    private String name;
}
