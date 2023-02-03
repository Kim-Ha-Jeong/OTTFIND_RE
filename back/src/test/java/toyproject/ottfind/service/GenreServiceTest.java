package toyproject.ottfind.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.ottfind.domain.Genre;
import toyproject.ottfind.repository.GenreRepository;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class GenreServiceTest {
    @Autowired
    GenreService genreService;

    @Autowired
    GenreRepository genreRepository;

    @Test
    void 장르_생성 () {
        Genre genre = new Genre();
        genre.setName("공포/스릴러");

        Integer id = genreService.save(genre);

        Genre findGenre = genreRepository.findById(id).get();
        assertEquals(genre.getName(), findGenre.getName());
    }

    @Test
    void 이름으로_장르_조회 () {
        String name = "공포/스릴러";

        Genre genre = new Genre();
        genre.setName(name);

        Integer id = genreService.save(genre);

        Genre findGenre = genreService.getGenreByname(name);
        assertThat(id).isEqualTo(findGenre.getId());
    }

    @Test
    void 중복으로_저장 () {
        String name = "공포/스릴러";

        Genre genre1 = new Genre();
        genre1.setName(name);

        Genre genre2 = new Genre();
        genre2.setName(name);

        genreService.save(genre1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> genreService.save(genre2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 genre입니다");
    }

    @Test
    void 없는_이름_조회() {
        String name = "공포/스릴러";

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> genreService.getGenreByname(name));
        assertThat(e.getMessage()).isEqualTo("없는 genre 입니다");
    }

}
