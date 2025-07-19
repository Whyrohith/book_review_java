package Book.Reviews.Book.reviews.Controller;

import java.util.List;


import Book.Reviews.Book.reviews.Entity.Users;
import Book.Reviews.Book.reviews.Response.RegistrationResponse;
import Book.Reviews.Book.reviews.Services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(usersService.allUsers(), HttpStatus.OK);
    }


    @PostMapping("/registration")
    public ResponseEntity<RegistrationResponse> addUser(@RequestBody Users user){
        Users registered  = usersService.addUser(user);
        RegistrationResponse response = new RegistrationResponse("Registration Successful", true , registered.getId());
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }






}
