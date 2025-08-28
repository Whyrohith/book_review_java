package Book.Reviews.Book.reviews.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reviews{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne // Many Reviews can belong to One Book
    @JoinColumn(name = "book_id", nullable = false)
    private Books book;

    @ManyToOne// Many Reviews can belong to One Book
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "created_at", nullable = false) // 'nullable = false' implies NOT NULL in DB
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false) // 'updated_at' is often nullable or updated on each save
    private LocalDateTime updatedAt;


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewText='" + comment + '\'' +
                ", rating=" + rating +
                ", bookId=" + (book != null ? book.getId() : "null") + // To avoid fetching entire book object in toString
                ", userId=" + (user != null ? user.getId() : "null") + // To avoid fetching entire user object in toString
                ", createdAt=" +  createdAt+
                ", updatedAt=" + updatedAt + '}';
    }
}
