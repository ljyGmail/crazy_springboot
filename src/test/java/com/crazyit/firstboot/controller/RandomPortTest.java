package com.crazyit.firstboot.controller;

import com.crazyit.firstboot.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandomPortTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testIndexRest() {
        // 测试restIndex方法
        var result = restTemplate.getForObject("/rest", String.class);
        Assertions.assertEquals("欢迎访问第一个Spring Boot应用", result);
    }

    @ParameterizedTest
    @CsvSource({"疯狂Java讲义, 李刚, 129.0", "疯狂Android讲义, 李刚, 128.0"})
    public void testRestAddBook(String title, String author, double price) {
        var book = new Book(title, author, price);
        // 测试restAddBook方法
        var result = restTemplate.postForObject("/rest/books", book, Map.class);
        Assertions.assertEquals(result.get("tip"), "添加成功");
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 9})
    public void testRestDelete(Integer id) {
        // 测试restDelete方法
        restTemplate.delete("/rest/books/{0}", id);
    }
}
