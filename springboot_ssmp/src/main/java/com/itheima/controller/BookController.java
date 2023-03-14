package com.itheima.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.mapper.BookMapper;
import com.itheima.service.BookService;
import com.itheima.service.IBookService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: fan-lihui
 * @Create: 2023/3/13 - 16:04
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll() {
        return new R(true, iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws Exception {
        if (book.getName().equals("123")) throw new Exception();
        boolean flag = iBookService.save(book);

        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");

    }

    //异步提交通过请求体传递json数据过来
    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(iBookService.modify(book));
    }

    //通过路径变量传参 http://localhost/books/2
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(iBookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, iBookService.getById(id));
    }

   // @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//
//        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于总页码值，那么重新执行查询操作，将最后一页作为当前页
//        if(page.getCurrent() > page.getPages()){
//            page = iBookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true,page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {

        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，将最后一页作为当前页
        if(page.getCurrent() > page.getPages()){
            page = iBookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }


}
