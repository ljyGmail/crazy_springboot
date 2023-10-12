package com.crazyit.firstboot.service;

import com.crazyit.firstboot.dao.BookDao;
import com.crazyit.firstboot.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MockTest {
    // 定义要测试的目标组件: BookService
    @Autowired
    private BookService bookService;

    // 为BookService依赖的组件定义一个Mock Bean
    // 该Mock Bean将会被注入被测试的目标组件
    @MockBean
    private BookDao bookDao;

    @Test
    public void testGetAllBooks() {
        // 模拟bookDao的findAll()方法的返回值
        BDDMockito.given(this.bookDao.findAll()).willReturn(
                List.of(new Book("测试1", "李刚", 89.9),
                        new Book("测试2", "yeeku", 99.9)));
        List<Book> result = bookService.getAllBooks();
        Assertions.assertEquals(result.get(0).getTitle(), "测试1");
        Assertions.assertEquals(result.get(0).getAuthor(), "李刚");
        Assertions.assertEquals(result.get(1).getTitle(), "测试2");
        Assertions.assertEquals(result.get(1).getAuthor(), "yeeku");
    }
}
