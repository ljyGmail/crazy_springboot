package com.crazyit.firstboot.service.impl;

import com.crazyit.firstboot.dao.BookDao;
import com.crazyit.firstboot.domain.Book;
import com.crazyit.firstboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, timeout = 5)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookDao.findAll();
    }

    @Override
    public Integer addBook(Book book) {
        bookDao.save(book);
        return book.getId();
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteById(id);
    }
}
