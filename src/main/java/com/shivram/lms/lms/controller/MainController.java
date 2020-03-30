package com.shivram.lms.lms.controller;

import com.shivram.lms.lms.model.Book;
import com.shivram.lms.lms.services.LmsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

@Controller
public class MainController {

    @Autowired
    private LmsServices lmsServices;

    @GetMapping(value = "/")
    public String init(HttpServletRequest request) {

        request.setAttribute("books", lmsServices.findAllBooks());
        request.setAttribute("mode", "BOOK_VIEW");
        return "index";

    }

    @GetMapping("/update-book")
    public String init(@RequestParam long id, HttpServletRequest request) {
        request.setAttribute("book", lmsServices.findOne(id));
        request.setAttribute("mode", "BOOK_EDIT");
        return "index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
    }

    @PostMapping("/saved")
    public void saved(@ModelAttribute Book book, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException {
        lmsServices.save(book);
        request.setAttribute("books", lmsServices.findAllBooks());
        request.setAttribute("mode", "BOOK_VIEW");
       response.sendRedirect("/");

    }

    @GetMapping("/new-book")
    public String addnewBook(HttpServletRequest request){

        request.setAttribute("mode","BOOK_NEW");
        return "index";
    }

    @GetMapping("/delete-book")
    public void deleteBook(@RequestParam long id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        lmsServices.deleteBookById(id);
        response.sendRedirect("/");
    }

//
}
