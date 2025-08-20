package Book.Reviews.Book.reviews.Services;

import Book.Reviews.Book.reviews.Entity.AddReview;
import Book.Reviews.Book.reviews.Entity.Books;
import Book.Reviews.Book.reviews.Entity.Reviews;
import Book.Reviews.Book.reviews.Entity.Users;
import Book.Reviews.Book.reviews.Exception.ReviewsNotFoundException;
import Book.Reviews.Book.reviews.Repository.BookRepository;
import Book.Reviews.Book.reviews.Repository.ReviewsRepository;
import Book.Reviews.Book.reviews.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    public ReviewsService(ReviewsRepository review, BookRepository bookRepository, UserRepository user){
        this.reviewsRepository = review;
        this.bookRepository = bookRepository;
        this.userRepository = user;
    }

    public List<Reviews> allReviews(){

        return reviewsRepository.findAll();
    }


    public String getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    public Optional<List<Reviews>> getUserReview(){

        String currName = getCurrentUser();
        Optional<Users> user = userRepository.findByName(currName);

        Optional<List<Reviews>> listReviews = reviewsRepository.findByUser(user);

        if(listReviews.isEmpty()){
            throw new ReviewsNotFoundException("No Reviews are Present");
        }

        return listReviews;

    }


    public Reviews addReview(AddReview addreview){

         Reviews review = new Reviews();

        if (review.getCreatedAt() == null) {
            review.setCreatedAt(LocalDateTime.now());
        }

        if (review.getUpdatedAt() == null) {
            review.setUpdatedAt(LocalDateTime.now());
        }


        Optional<Users> addeduser = userRepository.findByName(getCurrentUser());

        Optional<Books> addedBook = bookRepository.findByTitle(addreview.getBookName());

        if (addedBook.isPresent()) {
            review.setBook(addedBook.get()); 
        } else {
            throw new RuntimeException("Book not found: " + addreview.getBookName());
        }

        if(addeduser.isPresent()){
            review.setUser(addeduser.get());
        }  else {
            throw new RuntimeException("User not found: " + getCurrentUser());
        }

        Optional<Reviews> existBook = reviewsRepository.findByUserAndBook(addeduser, addedBook);

        if(existBook.isPresent()) return existBook.get();

        review.setComment(addreview.getComment());
        review.setRating(addreview.getRating());
        
        review.setCreatedAt(LocalDateTime.now());
        review.setCreatedAt(LocalDateTime.now());
//      review.toString();
        return reviewsRepository.save(review);
    }



}
