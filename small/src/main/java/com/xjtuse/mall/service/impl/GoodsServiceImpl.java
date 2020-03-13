package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.goods.Goods;
import com.xjtuse.mall.bean.goods.ParentCategory;
import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.mapper.GoodsMapper;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ListResultVo;
import com.xjtuse.mall.service.GoodsService;
import com.xjtuse.mall.service.MallService;
import com.xjtuse.mall.utils.ResultUtil;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 失了秩
 * @date 2020/3/12 22:59
 * @description
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper mapper;

    @Override
    public MapResultVo queryGoods(PageUtil pageUtil, Goods goods) {
        pageUtil.initStart();
        List<Goods> data = mapper.queryGoods(pageUtil, goods);
        int count = mapper.queryGoodsCount(goods);
        return ResultUtil.ok(data, count);
    }

    @Override
    public MapResultVo queryDetail(Goods goods) {
        return null;
    }

    @Override
    public MapResultVo queryCatAndBrand() {
        List brandList = mapper.queryBrandForGoods();
        List<ParentCategory> categoryList = mapper.queryL1CategoryForGoods();
        for (ParentCategory parentCategory : categoryList) {
            List categoryL2 = mapper.queryL2CategoryForGoods(parentCategory);
            parentCategory.setChildren(categoryL2);
        }
        Map map = new HashMap<>();
        map.put("brandList", brandList);
        map.put("categoryList", categoryList);
        return ResultUtil.catAndBrandOk(map);
    }
}
