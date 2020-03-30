package com.shivram.lms.lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "lms_tbl")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String author;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
