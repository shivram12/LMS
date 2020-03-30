package com.shivram.lms.lms.dao;

import com.shivram.lms.lms.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LmsRepository extends CrudRepository<Book,Long> {


}
