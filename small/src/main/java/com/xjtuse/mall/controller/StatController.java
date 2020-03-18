package com.xjtuse.mall.controller;

import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.TResultVo;
import com.xjtuse.mall.service.StatService;
import com.xjtuse.mall.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StatController {

    @Autowired
    StatService service;

    @RequestMapping("/stat/user")
    public TResultVo queryUserStat(){
        return service.queryUserStat();
    }

    @RequestMapping("/stat/order")
    public TResultVo queryOrderStat(){
        return service.queryOrderStat();
    }

    @RequestMapping("/stat/goods")
    public TResultVo queryGoodsStat(){
        return service.queryGoodsStat();
    }
}
