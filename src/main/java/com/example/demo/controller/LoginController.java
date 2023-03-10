package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.domain.User;
import com.example.demo.domain.vo.CommonConstant;
import com.example.demo.domain.vo.Result;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

@Api(tags = "登录模块")
@Slf4j
public class LoginController {
    @Resource
    UserService userService;
    @ApiOperation("登录")
    @PostMapping(value = "/login")
    public Result<Object> login(User user){
        log.info(user.toString());

        if (userService.list(new QueryWrapper<User>().eq("userid",user.getUserid())).size()==0){
            return Result.error(CommonConstant.LOGIN_ERROR,"用户不存在");
        }
        log.info(userService.list(new QueryWrapper<User>().eq("userid",user.getUserid())).toString());

        if (userService.getOne(new QueryWrapper<>(user))==null )
        {
            return  Result.error(CommonConstant.LOGIN_ERROR,"密码错误"); }
        else {
            return Result.ok("登录成功",userService.getOne(new QueryWrapper<>(user)));
        }
    }
}
