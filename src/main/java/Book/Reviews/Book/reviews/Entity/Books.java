package Book.Reviews.Book.reviews.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "books")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Books{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name= "author")
    private String author;
    private String isbn;
    @Column(name = "publication_year")
    private Integer pub_year;
    private String description;
    @Column(name = "cover_image_url")
    private String cover_img;
    @Column(name = "created_at", nullable = false) // 'nullable = false' implies NOT NULL in DB
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false) // 'updated_at' is often nullable or updated on each save
    private LocalDateTime updatedAt;

    @Override
    public String toString(){
        return "book{" +
                "id=" + id +
                ",author ='" + author + '\'' +
                ", title " + title +
                ", isbn =" + isbn + // To avoid fetching entire book object in toString
                ", cover_i =" +cover_img + // To avoid fetching entire user object in toString
                ", createdAt=" + createdAt+
                ", updatedAt=" + updatedAt +
                '}';
    }
}
