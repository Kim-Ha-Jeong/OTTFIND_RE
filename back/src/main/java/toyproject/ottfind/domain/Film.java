package toyproject.ottfind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "film")
public class Film {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Column(nullable = false, length = 200)
    private String title;

    @Setter
    @Column(nullable = false, length = 300, columnDefinition = "default '정보 없음'")
    private String poster_url;

    @Setter
    @Column(nullable = false, length = 45)
    private String type;

    @Setter
    @Column(nullable = false)
    private Integer year;

    @Setter
    @Column(nullable = false, columnDefinition = "default -1")
    private Integer time;

    @Setter
    @Column(nullable = false, columnDefinition = "default -1")
    private Integer season;

    @Getter @Setter
    @Column(nullable = false, length = 45)
    private String director;

    @Setter
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
