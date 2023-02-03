package toyproject.ottfind.repository;

import toyproject.ottfind.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends GeneralRepository<Genre>{
    Optional<Genre> findByGenrename(String name);
}
