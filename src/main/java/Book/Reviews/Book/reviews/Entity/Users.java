package Book.Reviews.Book.reviews.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String name;

    @Column(name = "password_hash")
    private String password;
    private String email;
    @Column(name = "created_at", nullable = false) // 'nullable = false' implies NOT NULL in DB
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false) // 'updated_at' is often nullable or updated on each save
    private LocalDateTime updatedAt;

    @Override
    public String toString(){
        return "user{" +
                "id=" + id +
                "name ='" + name + '\'' +
                ",email = " + email +
                ",createdAt=" + createdAt +
                ",updatedAt=" + updatedAt+
                '}';
    }

}
