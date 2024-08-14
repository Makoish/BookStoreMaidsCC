package com.maids.cc.bookStore.web;


import com.maids.cc.bookStore.model.Book;
import com.maids.cc.bookStore.model.Patron;
import com.maids.cc.bookStore.service.PatronService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@RestController

public class PatronController {


    private final PatronService patronService;



    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }



    @PostMapping("api/patrons")
    public ResponseEntity<Object> addPatron(@RequestBody Patron patron) {
        Pattern pattern = Pattern.compile("[A-Za-z][a-zA-Z0-9_]*@[A-Za-z]*\\.[A-za-z]{3}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(patron.getEmail());
        Map<String, Object> map = new HashMap<>();
        if (!matcher.matches()){
            map.put("message", "Wrong email format");
            return new ResponseEntity<Object>(
                    map,
                    HttpStatus.BAD_REQUEST);
        }



        patronService.save(patron);
        map.put("message", "User added");
        return new ResponseEntity<Object>(
                map,
                HttpStatus.OK);
    }

    @GetMapping("api/patrons")
    public ResponseEntity<Object> getPatrons() {
        Map<String, Object> map = new HashMap<>();
        map.put("Patrons", patronService.get());
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }


    @GetMapping("api/patrons/{id}")
    public ResponseEntity<Object> getPatron(@PathVariable int id) {
        Patron patron = patronService.get(id);
        Map<String, Object> map = new HashMap<>();
        if (patron == null){
            map.put("message", "User not found");
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        map.put("patron", patron);
        return new ResponseEntity<Object>(map, HttpStatus.OK);


    }

    @PutMapping("api/patrons/{id}")
    public ResponseEntity<Object> updatePatron(@PathVariable int id, @RequestBody Patron patron) {

        Patron patron2 = patronService.get(id);
        Map<String, Object> map = new HashMap<>();
        if (patron2 == null){
            map.put("message", "Patron not found");
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        Pattern pattern = Pattern.compile("[A-Za-z][a-zA-Z0-9_]*@[A-Za-z]*\\.[A-za-z]{3}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(patron.getEmail());
        if (!matcher.matches()){
            map.put("Message", "Wrong email format");
            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }

        patronService.updateItem(id, patron);
        map.put("message", "User updated");
        return new ResponseEntity<Object>(map, HttpStatus.OK);

    }

    @DeleteMapping("api/patrons/{id}")
    public ResponseEntity<Object> deletePatron(@PathVariable int id) {
        Patron patron = patronService.get(id);
        Map<String, Object> map = new HashMap<>();
        if (patron == null){
            map.put("message", "User not found");
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        patronService.remove(id);
        map.put("message", "User deleted");
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}



