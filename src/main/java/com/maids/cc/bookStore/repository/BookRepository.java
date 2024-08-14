package com.maids.cc.bookStore.repository;

import com.maids.cc.bookStore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
