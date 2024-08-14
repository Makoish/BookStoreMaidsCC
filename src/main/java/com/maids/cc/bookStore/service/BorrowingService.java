package com.maids.cc.bookStore.service;

import com.maids.cc.bookStore.model.Book;
import com.maids.cc.bookStore.model.Borrowing_record;
import com.maids.cc.bookStore.repository.BookRepository;
import com.maids.cc.bookStore.repository.BorrowingRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }


    public Iterable<Borrowing_record> get(){
        return borrowingRepository.findAll();
    }


    public Borrowing_record get(Integer id){
        return borrowingRepository.findById(id).orElse(null);
    }

    public void remove(Integer id){
        borrowingRepository.deleteById(id);
    }

    public Borrowing_record save(Borrowing_record record){
        borrowingRepository.save(record);
        return record;
    }






    public Borrowing_record updateItem(Integer id, Date returnDate) {
        return borrowingRepository.findById(id)
                .map(record -> {
                    record.setReturnDate(returnDate);
                    return borrowingRepository.save(record);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
    }

    public void returnBorrow(Integer patron, Integer bookID, Date returnDate ) {
        Optional<Borrowing_record> optionalRecord = borrowingRepository.findByPatronIDAndBookID(patron, bookID);
        if (optionalRecord.isPresent()) {
            Borrowing_record record = optionalRecord.get();
            record.setReturnDate(returnDate); // Example of updating a field
            borrowingRepository.save(record);
        } else {
            throw new ResourceNotFoundException("Borrowing record not found");
        }

    }
}

