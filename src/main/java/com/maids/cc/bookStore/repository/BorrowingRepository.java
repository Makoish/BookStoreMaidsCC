package com.maids.cc.bookStore.repository;

import com.maids.cc.bookStore.model.Borrowing_record;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface BorrowingRepository extends CrudRepository<Borrowing_record, Integer> {
    Optional<Borrowing_record> findByPatronIDAndBookID(Integer patronId, Integer bookId);
}
