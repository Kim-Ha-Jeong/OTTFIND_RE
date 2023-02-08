package toyproject.ottfind.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.ottfind.domain.Film;
import toyproject.ottfind.domain.Genre;
import toyproject.ottfind.domain.Review;
import toyproject.ottfind.domain.User;
import toyproject.ottfind.repository.ReviewInterface;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Transactional
public class ReviewServiceTest {
    private final UserService userService;
    private final FilmService filmService;

    private final GenreService genreService;
    private final ReviewService reviewService;
    private final ReviewInterface reviewRepository;

    static int userId, filmId;

    @Autowired
    public ReviewServiceTest(UserService userService, FilmService filmService, GenreService genreService, ReviewService reviewService, ReviewInterface reviewRepository) {
        this.userService = userService;
        this.filmService = filmService;
        this.genreService = genreService;
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    public Review setUpReview(){
        Genre genre = new Genre();
        genre.setName("스릴러/호러");
        genreService.save(genre);

        User user = new User();
        user.setUsername("김하정");
        user.setPassword("12345");

        Film film = new Film();
        film.setType("영화");
        film.setDirector("spring");
        film.setYear(2021);
        film.setTitle("바보");
        film.setGenre(genre);
        film.setCountry("미국");
        film.setContent("hihihihihihi");
        film.setTime(120);
        film.setSeason(-1);
        film.setPoster_url("정보없음");

        filmId = filmService.saveFilm(film);
        userId = userService.join(user);

        Review review = new Review();
        review.setUser(user);
        review.setFilm(film);
        review.setContent("hihihihi");

        return review;
    }

    @Test
    void 단순_저장 () {
        Review review = setUpReview();

        Integer id = reviewService.saveReview(review);
        Review findReview = reviewRepository.findById(id).get();

        assertThat(id).isEqualTo(findReview.getId());
    }

    @Test
    void 유저_id로_조회(){
        Review review = setUpReview();

        Integer id = reviewService.saveReview(review);
        Review findReview = reviewService.getReviewByUser(userId).get(0);

        assertThat(findReview.getId()).isEqualTo(id);
    }

    @Test
    void 영화_id로_조회 () {
        Review review = setUpReview();

        Integer id = reviewService.saveReview(review);
        Review findReview = reviewService.getReviewByFilm(filmId).get(0);

        assertThat(findReview.getId()).isEqualTo(id);
    }



}
