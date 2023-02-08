package toyproject.ottfind.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toyproject.ottfind.domain.Review;
import toyproject.ottfind.repository.GenreInterface;
import toyproject.ottfind.repository.ReviewInterface;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private final ReviewInterface reviewRepository;

    public ReviewService(ReviewInterface reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Integer saveReview(Review review){
        reviewRepository.save(review);
        return review.getId();
    }

    public List<Review> getReviewByUser(Integer id){
        return reviewRepository.findByUser(id);
    }

    public List<Review> getReviewByFilm(Integer id){
        return reviewRepository.findByFilm(id);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
}
