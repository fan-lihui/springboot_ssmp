package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: fan-lihui
 * @Create: 2023/3/13 - 14:22
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(3));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("小牛上天");
        book.setType("飞天秘籍");
        book.setDescription("搜搜的");

        boolean result = bookService.save(book);
        System.out.println(result);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(5);
        book.setName("java学不会大全");
        book.setType("编程类");
        book.setDescription("疯了都不会系列");

        boolean result = bookService.update(book);
        System.out.println(result);
    }
    @Test
    void testDelete(){
        Book book = new Book();
        book.setId(15);
        boolean result = bookService.delete(15);
        System.out.println(result);
    }
    @Test
    void testGetAll(){
        Book book = new Book();
        book.setName("啊啊啊啊");
        book.setType("AAAA");
        book.setDescription("aaaaaaaaa");

        List<Book> books = bookService.GetAll();
        books.forEach(System.out::println);
    }

    @Test
    void testPage(){
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
    }


}
