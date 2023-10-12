package com.crazyit.firstboot.service;

import com.crazyit.firstboot.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Integer addBook(Book book);

    void deleteBook(Integer id);
}
