package com.shivram.lms.lms.services;

import com.shivram.lms.lms.dao.LmsRepository;
import com.shivram.lms.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LmsServices {

    @Autowired
    private LmsRepository lmsRepository;

    public Collection<Book> findAllBooks(){
        List<Book> bookList = new ArrayList<>();

        for (Book books : lmsRepository.findAll()){

            bookList.add(books);
        }
        return bookList;
    }
    public void deleteBookById(long id){
        lmsRepository.deleteById(id);
    }

    public Book findOne(long id) {
        return lmsRepository.findById(id).orElse(null);
    }

    public void save(Book book){
        lmsRepository.save(book);
    }

}
