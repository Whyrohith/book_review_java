package Book.Reviews.Book.reviews.Controller;

import java.util.List;
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

    @GetMapping("/allUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<List<Users>>(usersService.allUsers(), HttpStatus.OK);
    }


    @PostMapping("/registration")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        Users savedUser = usersService.addUser(user);
        return new ResponseEntity<Users>(savedUser, HttpStatus.CREATED);
    }


}
