package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author CYF02
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-03-05 16:06:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




