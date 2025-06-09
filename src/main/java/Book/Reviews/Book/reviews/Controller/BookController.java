package Book.Reviews.Book.reviews.Controller;


import Book.Reviews.Book.reviews.Entity.Books;
import Book.Reviews.Book.reviews.Repository.BookRepository;
import Book.Reviews.Book.reviews.Services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){
        return new ResponseEntity<List<Books>>(booksService.allBooks(), HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Optional<Books>> singleBook(@PathVariable String isbn){
        return new ResponseEntity<Optional<Books>>(booksService.findByIsbn(isbn), HttpStatus.OK);

    }

    @PostMapping("/addBook")
    public ResponseEntity<Books> addBook(@RequestBody Books book){
        return new ResponseEntity<Books>(booksService.addBook(book),HttpStatus.CREATED);
    }
}
