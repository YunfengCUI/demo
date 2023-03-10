package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.domain.User;
import com.example.demo.domain.UserHistory;
import com.example.demo.domain.vo.Result;
import com.example.demo.service.UserHistoryService;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理模块")
@Slf4j
public class UserController {

    @Resource
    UserService userService;
    @Resource
    UserHistoryService userHistoryService;
    @ApiOperation("add")
    @PostMapping(value = "/addOrUpdate")
    public Result<Object> addupdate(User user){
        log.info(user.toString());
        if (userService.getById(user.getUserid())!=null) {
            if (userService.saveOrUpdate(user)) {
                UserHistory userHistory = new UserHistory(user);
                userHistoryService.saveOrUpdate(userHistory);
                return Result.ok("result", true);
            } else {
                return Result.ok("result", false);
            }
        }else {
            userService.save(user);
            return  Result.error("操作失败");
        }
    }
    @ApiOperation("del")
    @PostMapping(value = "/del")
    public Result<Object> del(User user){
        if (userService.removeById(user)){
            userHistoryService.saveOrUpdate(new UserHistory(user));
            return Result.ok("result",true);
        }else {
            return Result.ok("result",false);
        }

    }
    @ApiOperation("find")
    @PostMapping(value = "/find")
    public Result<Object> find(User user){
        log.info(user.toString());
        return Result.ok("result",userService.list(new QueryWrapper<>(user)));
    }

    @ApiOperation("获取修改历史")
    @PostMapping(value = "/history")
    public Result<Object> historyFind(UserHistory userHistory){
        return Result.ok("result",userHistoryService.list());
    }
}
