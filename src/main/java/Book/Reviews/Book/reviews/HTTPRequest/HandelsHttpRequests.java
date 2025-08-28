package Book.Reviews.Book.reviews.HTTPRequest;

import Book.Reviews.Book.reviews.Entity.Books;
import Book.Reviews.Book.reviews.Exception.SearchQueryFailedError;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;


@Repository
public class HandelsHttpRequests {

    private List<Books> convertToBooks(JsonNode json){
        if(json.isEmpty()) return Collections.emptyList();
        List<Books> resultBooks = new ArrayList<>();
        JsonNode docs = json.get("docs");
        long count  = 0L;
        for(JsonNode doc : docs){
            String coverKey = (doc.has("cover_edition_key")) ? doc.get("cover_edition_key").asText() : "";
            String cover_img = (Objects.equals(coverKey, "")) ? "" : "https://covers.openlibrary.org/b/olid/"+coverKey+"-M.jpg";
            String title = (doc.has("title")) ? doc.get("title").asText() : "";

            String author ="";
            if(doc.has("author_name")){
                author = doc.get("author_name").get(0).asText();
            }
            Integer pub = (doc.has("first_publish_year")) ? doc.get("first_publish_year").asInt() : 0;
            Books newBook = new Books(
                    ++count,
                    title,
                    author,
                    coverKey,
                    pub,
                    cover_img,
                    LocalDateTime.now(),
                    LocalDateTime.now()
                    );
            System.out.println(newBook);
            resultBooks.add(newBook);
        }

        System.out.println(resultBooks.size()); // 1

        return resultBooks;
    }


    public List<Books> getRequest(String name) {
        String stringUrl = "https://openlibrary.org/search.json?q=" + name;

        try {
            URL url = new URL(stringUrl);
            JsonNode jsonNode = getJsonNode(url);
            return convertToBooks(jsonNode);

        } catch(Exception e){
            throw new SearchQueryFailedError("Failed to get the book with Name= " + name.replace("+", " "));

        }
    }

    private static JsonNode getJsonNode(URL url) throws IOException {
        System.out.println(url.toString());
        HttpURLConnection  con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while((line = reader.readLine()) != null){
            response.append(line);
        }

        reader.close();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(response.toString());
    }
}
