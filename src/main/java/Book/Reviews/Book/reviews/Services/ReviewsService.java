package Book.Reviews.Book.reviews.Services;

import Book.Reviews.Book.reviews.Entity.Reviews;
import Book.Reviews.Book.reviews.Repository.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;

    public ReviewsService(ReviewsRepository review){

        this.reviewsRepository = review;
    }

    public List<Reviews> allReviews(){

        return reviewsRepository.findAll();
    }



}
