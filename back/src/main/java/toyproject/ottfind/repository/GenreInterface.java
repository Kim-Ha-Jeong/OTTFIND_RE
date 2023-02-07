package toyproject.ottfind.repository;

import toyproject.ottfind.domain.Genre;

import java.util.Optional;

public interface GenreInterface extends JpaRepository<Genre> {
    Optional<Genre> findByGenrename(String name);
}
