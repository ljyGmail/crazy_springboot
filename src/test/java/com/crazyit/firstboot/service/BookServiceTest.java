package com.crazyit.firstboot.service;

import com.crazyit.firstboot.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        bookService.getAllBooks().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"疯狂Java讲义, 李刚, 129.0", "疯狂Android讲义, 李刚, 128.0"})
    public void testAddBook(String title, String author, double price) {
        var book = new Book(title, author, price);
        Integer result = bookService.addBook(book);
        System.out.println(result);
        // Assertions.assertEquals(result, 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11})
    public void testDeleteBook(Integer id) {
        bookService.deleteBook(id);
    }
}
