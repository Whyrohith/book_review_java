package Book.Reviews.Book.reviews.Entity;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddReview {

    private String bookName;
    private String comment;
    private Integer rating;


    @Override
    public String toString(){
        return "AddReview{ " +
                "Book Name = " + bookName +
                "}";
    }
}
