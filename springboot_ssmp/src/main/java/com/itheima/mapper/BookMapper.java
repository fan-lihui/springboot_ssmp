package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author: fan-lihui
 * @Create: 2023/3/13 - 11:46
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
