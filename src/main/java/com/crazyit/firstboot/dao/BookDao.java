package com.crazyit.firstboot.dao;

import com.crazyit.firstboot.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {
}
