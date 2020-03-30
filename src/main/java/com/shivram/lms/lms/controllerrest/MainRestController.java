package com.shivram.lms.lms.controllerrest;

import com.shivram.lms.lms.model.Book;
import com.shivram.lms.lms.services.LmsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MainRestController {

    @Autowired
    private LmsServices lmsServices;

//    @GetMapping(value = "/")
//    public String hello(){
//
//        return "hello";
//    }

    @GetMapping("/find-all-books")
    public Collection<Book> getAllBooks(){

       return lmsServices.findAllBooks();
    }

    @GetMapping("/delete")
    public void deleteBook(@RequestParam  long id ){

        lmsServices.deleteBookById(id);
    }
}
