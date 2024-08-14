package com.maids.cc.bookStore.service;

import com.maids.cc.bookStore.model.Book;
import com.maids.cc.bookStore.repository.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    public Iterable<Book> get(){
        return bookRepository.findAll();
    }


    public Book get(Integer id){
        return bookRepository.findById(id).orElse(null);
    }

    public void remove(Integer id){
        bookRepository.deleteById(id);
    }

    public Book save(Book patron){
        bookRepository.save(patron);
        return patron;
    }

    public Book updateItem(Integer id, Book updatedItem) {
        return bookRepository.findById(id)
                .map(Book -> {
                    Book.setTitle(updatedItem.getTitle());
                    Book.setIsbn(updatedItem.getIsbn());
                    Book.setPublicationYear(updatedItem.getPublicationYear());
                    Book.setAuthor(updatedItem.getAuthor());
                    return bookRepository.save(Book);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
    }
}

