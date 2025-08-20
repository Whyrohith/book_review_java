package Book.Reviews.Book.reviews.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ReviewsNotFoundException extends RuntimeException{

    public ReviewsNotFoundException(String message){
        super(message);
    }
}
