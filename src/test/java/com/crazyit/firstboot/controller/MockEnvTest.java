package com.crazyit.firstboot.controller;

import com.crazyit.firstboot.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MockEnvTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndex() throws Exception {
        // 测试index方法
        var result = mvc.perform(MockMvcRequestBuilders.get(new URI("/"))).andReturn().getModelAndView();
        Assertions.assertEquals(Map.of("tip", "欢迎访问第一个Spring Boot应用"), result.getModel());
        Assertions.assertEquals("hello", result.getViewName());
    }

    @ParameterizedTest
    @CsvSource({"疯狂Java讲义, 李刚, 129.0", "疯狂Android讲义, 李刚, 128.0"})
    public void testAddBook(String title, String author, double price) throws Exception {
        // 测试addBook方法
        var result = mvc.perform(MockMvcRequestBuilders
                        .post(new URI("/addBook"))
                        .param("title", title)
                        .param("author", author)
                        .param("price", price + ""))
                .andReturn().getModelAndView();
        Assertions.assertEquals("redirect:listBooks", result.getViewName());
    }

    @Test
    public void testList() throws Exception {
        // 测试 list方法
        var result = mvc.perform(MockMvcRequestBuilders.get(new URI("/listBooks")))
                .andReturn().getModelAndView();
        Assertions.assertEquals("list", result.getViewName());
        List<Book> books = (List<Book>) result.getModel().get("books");
        books.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 13})
    public void testDelete(Integer id) throws Exception {
        // 测试delete方法
        var result = mvc.perform(MockMvcRequestBuilders.get("/deleteBook?id={0}", id))
                .andReturn().getModelAndView();
        Assertions.assertEquals("redirect:listBooks", result.getViewName());
    }
}
