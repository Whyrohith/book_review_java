# API Documentation
Hi, this is the API documentation for the Book Review app I am working on as my personal project.
It was developed using Java and Spring Boot. Even though my initial motivation was to learn microservices,
I ended up implementing everything as a single service. Because of that, the app may feel a bit heavy and complex.
So I created this file to list and explain all the API endpoints used in the project.

## Base Url : http://localhost:8080/{CommonEndPoint}/{EndPoint}

## Start by controller

The first thing is that you have to log in to get the access for all the endpoints
## User Controller

### User CommonEndPoint = /api/users

### User EndPoint
     1. GET /allUsers 
            Description: Get all the users
            Authentication: Required

     2. POST /registration
            Description: registration of new user, Make sure your sending the values in the body
            Authentication: Not Required
            Request Body(JSON):
                {
                    "name" : ,
                    "password": ,
                    "email":
                }


### Book Controller

### Book CommonEndPoint = /api/books

### Book EndPoint

    1. GET /allBooks
        Description: Get all the Books
        Authentication: Required
    
    2. GET /{title}
        Description: Get book with title
        Authentication: Required
        Path Variable: title

    3. POST /addBook
        Descritption: Add the book
        Authentication: Required
        Request Body(JSON)
            {
                "title" : "",
                "author": "",
                "isbn": "",
                "pub_year": "",
                "description": "",
                "cover_img": ""
            }
    
    4. DELETE /deleteBook/{isbn}
        Description: Delete the Book with isbn number
        Authentication: Required
        Path Variable: isbn

### Search Contrller


### Search CommonEndPoint = /api


### Search EndPoint

    1. GET /books/serch
        Description: Get the book your Searching. Getting it from open library
        Authentication: Required
        RequestParameters: name = ""




### Review Contrller


### Review CommonEndPoint = /api/reviews


### Review EndPoint

    1. GET /allReviews
        Description: Get all the Reviews in the database
        Authentication: Required
    
    2. POST /addReview
        Description: Add your review to database
        Authentication: Required
    
    3. GET /myReviews
        Description: Get all your reviews
        Authentication: Required
