package Book.Reviews.Book.reviews.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SearchQueryFailedError extends RuntimeException{

    public SearchQueryFailedError(String message){
        super(message);
    }
}
