package Book.Reviews.Book.reviews.Controller;

import java.util.Optional;

import Book.Reviews.Book.reviews.Entity.Reviews;
import Book.Reviews.Book.reviews.Entity.Users;
import Book.Reviews.Book.reviews.Services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }


//    @GetMapping("/login")
//    public ResponseEntity<Optional<Reviews>> login(@RequestBody Users user){
//        return usersService.verify(user);
//    }
    @PostMapping("/registration")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        Users savedUser = usersService.addUser(user);
        return new ResponseEntity<Users>(savedUser, HttpStatus.CREATED);
    }



}
