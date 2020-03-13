package com.xjtuse.mall.controller;

import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.result.SingleResultVo;
import com.xjtuse.mall.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 失了秩
 * @date 2020/3/13 9:11
 * @description
 */
@RestController
public class MallController {

    @Autowired
    MallService mallService;

    //商品类目
    @RequestMapping("/category/list")
    public SingleResultVo categoryList() {
        return mallService.queryCategory();
    }

    @RequestMapping("/category/l1")
    public SingleResultVo categoryL1() {
        return mallService.queryCategoryL1();
    }
}
