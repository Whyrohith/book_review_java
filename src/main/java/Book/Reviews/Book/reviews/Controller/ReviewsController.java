package Book.Reviews.Book.reviews.Controller;


import Book.Reviews.Book.reviews.Entity.AddReview;
import Book.Reviews.Book.reviews.Entity.Reviews;
import Book.Reviews.Book.reviews.Services.ReviewsService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;


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

    //accept the in body
    @PostMapping("/addReview")
    public ResponseEntity<Reviews> addReview(@RequestBody AddReview review){
       return new ResponseEntity<Reviews>(reviewsService.addReview(review), HttpStatus.CREATED);
    }


    @GetMapping("/myReviews")
    public ResponseEntity<List<Reviews>> myReviews(){
        List<Reviews>  resultReviews = reviewsService.getUserReview().orElse(Collections.emptyList());
        return ResponseEntity.ok(resultReviews);
    }

}
