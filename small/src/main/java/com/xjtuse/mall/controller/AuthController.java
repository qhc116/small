package com.xjtuse.mall.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {
    @RequestMapping("/auth/login")
    public Map login(@RequestBody HashMap data) {
//        return "{\"errno\":0,\"data\":{\"adminInfo\":{\"nickName\":\"admin123\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"},\"token\":\"45963731-edae-4dd2-a54c-fe70266165ad\"},\"errmsg\":\"成功\"}";
        Map<String,Object> map = new HashMap<>();
        String username = (String)data.get("username");
        String password= (String)data.get("password");
        map.put("errno",0);
        map.put("errmsg","成功");
        return map;
    }

    @RequestMapping("/auth/info")
    public Map info(){
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();

        map2.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map2.put("name","admin123");
        List perms = new ArrayList();
        perms.add("*");
        List roles = new ArrayList();
        roles.add("超级管理员");
        map2.put("perms",perms);
        map2.put("roles",roles);
        map1.put("data",map2);
        map1.put("errmsg","成功");
        map1.put("errno",0);
        return map1;
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "{\"errno\":0,\"data\":{\"goodsTotal\":99999999999999999999,\"userTotal\":10000000000000,\"productTotal\":241,\"orderTotal\":15},\"errmsg\":\"成功\"}";
    }
}
