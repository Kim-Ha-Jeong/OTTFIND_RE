package toyproject.ottfind.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.ottfind.domain.Film;
import toyproject.ottfind.domain.Genre;
import toyproject.ottfind.repository.FilmRepository;
import toyproject.ottfind.repository.GenreRepository;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class FilmServiceTest {

    private final GenreRepository genreRepository;
    private final GenreService genreService;
    private final FilmService filmService;
    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceTest(FilmService filmService, FilmRepository filmRepository, GenreService genreService, GenreRepository genreRepository){
        this.filmService = filmService;
        this.filmRepository = filmRepository;
        this.genreService = genreService;
        this.genreRepository = genreRepository;
    }

    public Film setUp() {
        Genre genre = new Genre();
        genre.setName("스릴러/호러");

        int genreId = genreService.save(genre);

        Optional<Genre> gen = genreRepository.findById(genreId);

        Film film = new Film();

        film.setType("영화");
        film.setDirector("spring");
        film.setYear(2021);
        film.setTitle("바보");
        film.setGenre(gen.get());
        film.setCountry("미국");
        film.setContent("hihihihihihi");
        film.setTime(120);
        film.setSeason(-1);
        film.setPoster_url("정보없음");

        return film;
    }

    @Test
    void 영화_저장(){

        Film film = setUp();
        Integer id = filmService.saveFilm(film);

        Film findFilm = filmRepository.findById(id).get();
        assertEquals(id, findFilm.getId());
    }
}
