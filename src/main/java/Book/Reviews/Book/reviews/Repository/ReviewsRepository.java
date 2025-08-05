package Book.Reviews.Book.reviews.Repository;

import Book.Reviews.Book.reviews.Entity.Books;
import Book.Reviews.Book.reviews.Entity.Reviews;
import Book.Reviews.Book.reviews.Entity.Users;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Id>{

        Optional<Reviews> findByUserAndBook(Optional<Users> user , Optional<Books> book);

        Optional<List<Reviews>> findByUser(Optional<Users> user);
}
