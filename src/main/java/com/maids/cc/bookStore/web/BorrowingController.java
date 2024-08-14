package com.maids.cc.bookStore.web;



import com.maids.cc.bookStore.model.Book;
import com.maids.cc.bookStore.model.Borrowing_record;
import com.maids.cc.bookStore.model.Patron;
import com.maids.cc.bookStore.service.BookService;
import com.maids.cc.bookStore.service.BorrowingService;
import com.maids.cc.bookStore.service.PatronService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class BorrowingController {
    private final BookService bookService;
    private final BorrowingService borrowingService;
    private final PatronService patronService;
    BorrowingController(BookService bookService, BorrowingService borrowingService, PatronService patronService) {
        this.bookService = bookService;
        this.borrowingService = borrowingService;
        this.patronService = patronService;
    }


    @PostMapping("api/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<Object> borrowBook(@PathVariable int bookId,@PathVariable int patronId) {

        Map<String, Object> map = new HashMap<>();
        Patron patron = patronService.get(patronId);
        if (patron == null){
            map.put("message", "Patron not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        Book book = bookService.get(bookId);
        if (book == null){
            map.put("message", "Book not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }


        Borrowing_record rr = new Borrowing_record();
        rr.setBookID(bookId);
        rr.setPatronID(patronId);
        rr.setBorrowDate(new Date());
        borrowingService.save(rr);

        map.put("message", "Record added");
        return new ResponseEntity<Object>(map, HttpStatus.OK);

    }



    @PutMapping("api/return/{bookId}/patron/{patronId}")
    public ResponseEntity<Object> returnBook(@PathVariable int bookId,@PathVariable int patronId) {

        Map<String, Object> map = new HashMap<>();
        Patron patron = patronService.get(patronId);
        if (patron == null){
            map.put("message", "Patron not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        Book book = bookService.get(bookId);
        if (book == null){
            map.put("message", "Book not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }



        borrowingService.returnBorrow(patronId, bookId, new Date());

        map.put("message", "Book returned");
        return new ResponseEntity<Object>(map, HttpStatus.OK);

    }
}
