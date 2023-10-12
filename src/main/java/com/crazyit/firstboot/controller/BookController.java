package com.crazyit.firstboot.controller;

import com.crazyit.firstboot.domain.Book;
import com.crazyit.firstboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tip", "欢迎访问第一个Spring Boot应用");
        return "hello";
    }

    @GetMapping("/rest")
    @ResponseBody
    public ResponseEntity restIndex() {
        return new ResponseEntity("欢迎访问第一个Spring Boot应用", null, HttpStatus.OK);
    }

    // ------------------------------------------------------------

    @PostMapping("/addBook")
    public String addBook(Book book, Model model) {
        bookService.addBook(book);
        return "redirect:listBooks";
    }

    @PostMapping("/rest/book")
    @ResponseBody
    public ResponseEntity<Map<String, String>> restAddBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(Map.of("tip", "添加成功"), null, HttpStatus.OK);
    }

    @GetMapping("/listBooks")
    public String list(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "list";
    }

    @GetMapping("/rest/books")
    @ResponseBody
    public ResponseEntity<List<Book>> restList() {
        return new ResponseEntity<>(bookService.getAllBooks(), null, HttpStatus.OK);
    }

    @GetMapping("/deleteBook")
    public String delete(Integer id) {
        bookService.deleteBook(id);
        return "redirect:listBooks";
    }

    @DeleteMapping("/rest/books/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> restDelete(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(Map.of("tip", "删除成功"), null, HttpStatus.OK);
    }
}
