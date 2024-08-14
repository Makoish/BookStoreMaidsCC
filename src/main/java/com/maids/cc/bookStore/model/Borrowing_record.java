package com.maids.cc.bookStore.model;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("BORROWING_RECORD")
public class Borrowing_record {

    @Id
    private Integer id;
    private Integer patronID;
    private Integer bookID;
    private Date borrowDate;
    private Date returnDate;

    public Integer getPatronID() {
        return patronID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setPatronID(Integer patronID) {
        this.patronID = patronID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }
}
