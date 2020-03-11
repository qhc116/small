package com.xjtuse.mall.controller;

import com.xjtuse.mall.bean.User;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public ResultVo<User> userList() {
        ResultVo result = userService.queryById();
        return result;
    }

    @RequestMapping("/test")
    public String usertest() {
        return "usertest";
    }


}
