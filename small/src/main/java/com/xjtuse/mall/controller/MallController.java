package com.xjtuse.mall.controller;

import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ListResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.MallService;
import com.xjtuse.mall.utils.PageUtil;
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
    public ResultVo categoryList() {
        return mallService.queryCategory();
    }

    //L1商品类目
    @RequestMapping("/category/l1")
    public ResultVo categoryL1() {
        return mallService.queryCategoryL1();
    }

    //供应商查询
    @RequestMapping("/brand/list")
    public ResultVo brandList(PageUtil pageUtil, Brand brand) {
        return mallService.queryBrand(pageUtil, brand);
    }
}
