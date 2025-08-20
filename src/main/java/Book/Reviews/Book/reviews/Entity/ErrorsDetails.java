package Book.Reviews.Book.reviews.Entity;

import java.time.LocalDateTime;

public class ErrorsDetails {
    private String message;
    private LocalDateTime date;
    private String details;

    public ErrorsDetails(LocalDateTime date,String message, String details) {
        this.message = message;
        this.date = date;
        this.details = details;
    }


    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }
}
