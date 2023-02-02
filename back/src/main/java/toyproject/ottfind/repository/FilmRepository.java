package toyproject.ottfind.repository;

import toyproject.ottfind.domain.Film;
import toyproject.ottfind.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends GeneralRepository<Film>{
    List<Film> findByTitle(String title);
    Optional<Film> findByYear(int year);
    Optional<Film> findByGenre(Genre genre);
    Optional<Film> findByCountry(String country);
}
