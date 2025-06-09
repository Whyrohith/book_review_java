package Book.Reviews.Book.reviews.Repository;


import Book.Reviews.Book.reviews.Entity.Users;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Id> {

    Optional<Users> findByName(String userName);
}
