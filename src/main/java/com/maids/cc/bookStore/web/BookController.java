package com.maids.cc.bookStore.web;


import com.maids.cc.bookStore.model.Book;

import com.maids.cc.bookStore.model.Patron;
import com.maids.cc.bookStore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("api/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        Pattern pattern = Pattern.compile("\\d{4}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(book.getPublicationYear());
        Map<String, Object> map = new HashMap<>();
        if (!matcher.matches()) {
           map.put("message", "Invalid Publication Year");
           return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }

        map.put("message", "Book added");
        bookService.save(book);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }


    @GetMapping("api/books")
    public ResponseEntity<Object> getBooks() {
        Map<String, Object> map = new HashMap<>();
        map.put("Books", bookService.get());
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }


    @GetMapping("api/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id) {
        Book book = bookService.get(id);
        Map<String, Object> map = new HashMap<>();
        if (book == null){
            map.put("message", "Book not found");
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        map.put("book", book);
        return new ResponseEntity<Object>(map, HttpStatus.OK);


    }

    @PutMapping("api/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody Book book) {

        Book book2 = bookService.get(id);
        Map<String, Object> map = new HashMap<>();
        if (book2 == null){
            map.put("message", "Book not found");
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        Pattern pattern = Pattern.compile("\\d{4}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(book.getPublicationYear());
        if (!matcher.matches()) {
            map.put("message", "Invalid Publication Year");
            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }

        bookService.updateItem(id, book);
        map.put("message", "Book updated");
        return new ResponseEntity<Object>(map, HttpStatus.OK);

    }


    @DeleteMapping("api/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id) {
        Book book = bookService.get(id);
        Map<String, Object> map = new HashMap<>();
        if (book == null){
            map.put("message", "Book not found");
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        bookService.remove(id);
        map.put("message", "Book deleted");
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
