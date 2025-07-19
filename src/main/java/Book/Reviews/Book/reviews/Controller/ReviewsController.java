package Book.Reviews.Book.reviews.Controller;


import Book.Reviews.Book.reviews.Entity.Reviews;
import Book.Reviews.Book.reviews.Services.ReviewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService){

        this.reviewsService = reviewsService;

    }


    @GetMapping("/allReviews")
    public ResponseEntity<List<Reviews>> getAllReviews(){

        return new ResponseEntity<List<Reviews>>(reviewsService.allReviews(), HttpStatus.OK);
    }

}
