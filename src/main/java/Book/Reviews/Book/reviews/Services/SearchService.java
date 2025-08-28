package Book.Reviews.Book.reviews.Services;


import Book.Reviews.Book.reviews.Entity.Books;
import Book.Reviews.Book.reviews.HTTPRequest.HandelsHttpRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private HandelsHttpRequests handelsHttpRequests;


    public List<Books> resultBooks(String name){
        String query = name.replace(" " , "+");
        return handelsHttpRequests.getRequest(query);
    }


}
