package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.BookRequestDate;
import com.example.demo.service.BookRequestDateService;
import com.example.demo.dao.mapper.BookRequestDateMapper;
import org.springframework.stereotype.Service;

/**
* @author CYF02
* @description 针对表【book_request_date】的数据库操作Service实现
* @createDate 2023-03-07 00:07:49
*/
@Service
public class BookRequestDateServiceImpl extends ServiceImpl<BookRequestDateMapper, BookRequestDate>
    implements BookRequestDateService{

}




