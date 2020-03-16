package com.xjtuse.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.xjtuse.mall.bean.goods.*;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.GoodsService;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

/**
 * @author 失了秩
 * @date 2020/3/12 22:56
 * @description
 */
@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods/list")
    public ResultVo goodslist(PageUtil pageUtil, Goods goods) {
        return goodsService.queryGoods(pageUtil, goods);
    }

    @RequestMapping("/goods/detail")
    public ResultVo goodsDetail(Goods goods) {
        return goodsService.queryDetail(goods);
    }

    @RequestMapping("/goods/catAndBrand")
    public ResultVo catAndBrand(Goods goods) {
        return goodsService.queryCatAndBrand();
    }

    @RequestMapping("/goods/update")
    public ResultVo goodsUpdate(@RequestBody GoodsData data) {
        return goodsService.updateGoods(data);
    }

    @RequestMapping("/goods/delete")
    public ResultVo goodsDelete(@RequestBody Goods goods) {
        return goodsService.goodsDelete(goods);
    }

    @RequestMapping("/goods/create")
    public ResultVo goodsCreate(@RequestBody GoodsData data) {
        return goodsService.goodsCreate(data);
    }



}
