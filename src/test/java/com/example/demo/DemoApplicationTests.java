package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
    @Resource
    BookService bookService;
    @Test
    void contextLoads() {
    }
    @Test
    void findbook(){

        Book book = new Book();
        book.setAuthor("张三");
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>(book);
        log.debug(bookService.list(bookQueryWrapper).toString());
    }

}
