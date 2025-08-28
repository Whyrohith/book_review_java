package Book.Reviews.Book.reviews.Controller;


import Book.Reviews.Book.reviews.Entity.Books;
import Book.Reviews.Book.reviews.Services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class SeviceController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/books/search")
    public ResponseEntity<List<Books>> searchBooks(@RequestParam String name){
        String newName = name.replace(" ", "+");
        List<Books> resultBooks = searchService.resultBooks(newName);
        return ResponseEntity.ok(resultBooks);
    }




}
