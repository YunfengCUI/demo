package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.State;
import com.example.demo.service.StateService;
import com.example.demo.dao.mapper.StateMapper;
import org.springframework.stereotype.Service;

/**
* @author CYF02
* @description 针对表【state】的数据库操作Service实现
* @createDate 2023-03-03 00:01:30
*/
@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State>
    implements StateService{

}




