package Book.Reviews.Book.reviews.Services;


import Book.Reviews.Book.reviews.Entity.Reviews;
import Book.Reviews.Book.reviews.Entity.Users;
import Book.Reviews.Book.reviews.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsersService {

    public final UserRepository userRepository;
    public final PasswordEncoder password;

    public UsersService(PasswordEncoder pass,UserRepository userRepository){
        this.userRepository = userRepository;
        this.password = pass;
    }

    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    public Users addUser(Users newUser) {
        if(newUser.getPassword() !=  null){
            newUser.setPassword(password.encode(newUser.getPassword()));
        }
        if (newUser.getCreatedAt() == null) {
            newUser.setCreatedAt(LocalDateTime.now());
        }

        if (newUser.getUpdatedAt() == null) {
            newUser.setUpdatedAt(LocalDateTime.now());
        }
        return userRepository.save(newUser);
    }
}
