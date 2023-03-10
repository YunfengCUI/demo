package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.BookRequest;
import com.example.demo.service.BookRequestService;
import com.example.demo.dao.mapper.BookRequestMapper;
import org.springframework.stereotype.Service;

/**
* @author CYF02
* @description 针对表【book_request】的数据库操作Service实现
* @createDate 2023-03-03 00:01:18
*/
@Service
public class BookRequestServiceImpl extends ServiceImpl<BookRequestMapper, BookRequest>
    implements BookRequestService{

}




