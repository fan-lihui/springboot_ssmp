package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.domain.Book;
import com.itheima.mapper.BookMapper;

/**
 * 业务层使用继承 IService 接口的方式快速开发
 * @Author: fan-lihui
 * @Create: 2023/3/13 - 15:25
 */
public interface IBookService extends IService<Book> {
    //追加方法
    boolean saveBook(Book book);
    boolean modify(Book book);//修改
    boolean delete(Integer id);
    IPage<Book> getPage(int currentPage,int pageSize);
    IPage<Book> getPage(int currentPage,int pageSize,Book book);
}
