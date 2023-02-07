package toyproject.ottfind.repository;

import toyproject.ottfind.domain.Review;

import java.util.List;

public interface ReviewInterface extends JpaRepository<Review> {
    List<Review> findByUser(Integer id);
    List<Review> findByFilm(Integer id);
}
