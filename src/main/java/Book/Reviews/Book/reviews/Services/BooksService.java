package Book.Reviews.Book.reviews.Services;


import Book.Reviews.Book.reviews.Entity.Books;
import Book.Reviews.Book.reviews.Repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {


    private final BookRepository bookRepository;
    public BooksService(BookRepository book){
        this.bookRepository = book;
    }

    public List<Books> allBooks(){
        return bookRepository.findAll();
    }

    public Optional<Books> findByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public Books addBook(Books book){
        if (book.getCreatedAt() == null) {
            book.setCreatedAt(LocalDateTime.now());
        }

        if (book.getUpdatedAt() == null) {
            book.setUpdatedAt(LocalDateTime.now());
        }
        return bookRepository.save(book);
    }

    @Transactional
    public Books deleteBook(String isbn){
        Optional<Books> bookOptional = bookRepository.findByIsbn(isbn);
        if(bookOptional.isPresent()){
            Books bookToDelete = bookOptional.get();
            bookRepository.delete(bookToDelete);
            return bookToDelete;
        }else {
            throw new RuntimeException("Book with" + isbn + "is not found");
        }
    }
}
