package Book.Reviews.Book.reviews.Exception;


import Book.Reviews.Book.reviews.Entity.ErrorsDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorsDetails> handleAllExcepitons(Exception ex, WebRequest request){
        ErrorsDetails errorsDetails = new ErrorsDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorsDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BookNotFoundException.class)
    public final ResponseEntity<ErrorsDetails> handleBookNotFoundExcepitons(Exception ex, WebRequest request){
        ErrorsDetails errorsDetails = new ErrorsDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorsDetails, HttpStatus.NOT_FOUND);
    }
}
