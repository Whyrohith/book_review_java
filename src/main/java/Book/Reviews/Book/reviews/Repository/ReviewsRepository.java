package Book.Reviews.Book.reviews.Repository;

import Book.Reviews.Book.reviews.Entity.Reviews;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Id>{



}
