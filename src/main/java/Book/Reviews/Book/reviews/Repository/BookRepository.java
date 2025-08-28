package Book.Reviews.Book.reviews.Repository;

import Book.Reviews.Book.reviews.Entity.Books;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Id> {


    Optional<Books> findByTitle(String name);
}
