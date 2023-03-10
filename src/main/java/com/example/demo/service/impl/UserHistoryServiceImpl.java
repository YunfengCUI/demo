package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.UserHistory;
import com.example.demo.service.UserHistoryService;
import com.example.demo.dao.mapper.UserHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author CYF02
* @description 针对表【user_history】的数据库操作Service实现
* @createDate 2023-03-05 19:19:33
*/
@Service
public class UserHistoryServiceImpl extends ServiceImpl<UserHistoryMapper, UserHistory>
    implements UserHistoryService{

}




