package com.itheima.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;

import java.util.List;

/**
 * 业务层标准开发
 * @Author: fan-lihui
 * @Create: 2023/3/13 - 11:50
 */

public interface BookService {
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> GetAll();
    IPage<Book> getPage(int currentPage,int pageSize);

}
