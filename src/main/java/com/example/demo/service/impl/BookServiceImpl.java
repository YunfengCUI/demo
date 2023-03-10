package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import com.example.demo.dao.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author CYF02
* @description 针对表【book】的数据库操作Service实现
* @createDate 2023-03-05 14:31:20
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




