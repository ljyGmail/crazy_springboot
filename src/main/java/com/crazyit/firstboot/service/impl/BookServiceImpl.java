package com.crazyit.firstboot.service.impl;

import com.crazyit.firstboot.domain.Book;
import com.crazyit.firstboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    static List<Book> booksDb = List.of(
            new Book(1, "疯狂Java讲义", "java.png", "李刚", 128.0),
            new Book(2, "轻量级Java Web企业应用实战", "javaweb.png", "李刚", 138.0),
            new Book(3, "疯狂Android讲义", "android.png", "李刚", 138.0),
            new Book(4, "疯狂Python讲义", "python.png", "李刚", 128.0)
    );

    @Override
    public Book getBookById(int id) {
        // 根据id来获取对应的图书
        return booksDb.stream().filter(b -> b.getId() == id).findFirst().get();
    }
}
