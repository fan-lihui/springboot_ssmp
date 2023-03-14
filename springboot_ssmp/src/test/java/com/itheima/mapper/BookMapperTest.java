package com.itheima.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: fan-lihui
 * @Create: 2023/3/13 - 11:55
 */
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testGetById(){
        System.out.println(bookMapper.selectById(3));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("啊啊啊啊");
        book.setType("AAAA");
        book.setDescription("aaaaaaaaa");

        int result = bookMapper.insert(book);
        System.out.println(result);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(15);
        book.setName("java学不会大全");
        book.setType("编程类");
        book.setDescription("疯了都不会系列");

        int result = bookMapper.updateById(book);
        System.out.println(result);
    }
    @Test
    void testDelete(){
        Book book = new Book();
        book.setId(15);
        int result = bookMapper.deleteById(book);
        System.out.println(result);
    }
    @Test
    void testGetAll(){
        Book book = new Book();
        book.setName("啊啊啊啊");
        book.setType("AAAA");
        book.setDescription("aaaaaaaaa");

        List<Book> books = bookMapper.selectList(null);
        books.forEach(System.out::println);
    }
    @Test
    void testPage(){
        IPage page = new Page(1,5);
        bookMapper.selectPage(page,null);
    }

    @Test
    void testByCondition(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "1");
        bookMapper.selectList(qw);
    }

    @Test
    void testByCondition1(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!= null, Book::getName, name);
        bookMapper.selectList(lqw);
    }

}
