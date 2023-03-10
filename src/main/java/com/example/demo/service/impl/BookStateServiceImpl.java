package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.BookState;
import com.example.demo.service.BookStateService;
import com.example.demo.dao.mapper.BookStateMapper;
import org.springframework.stereotype.Service;

/**
* @author CYF02
* @description 针对表【book_state】的数据库操作Service实现
* @createDate 2023-03-03 01:01:23
*/
@Service
public class BookStateServiceImpl extends ServiceImpl<BookStateMapper, BookState>
    implements BookStateService{

}




