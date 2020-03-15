package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.goods.*;
import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.mapper.GoodsMapper;
import com.xjtuse.mall.mapper.MallMapper;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ListResultVo;
import com.xjtuse.mall.result.ResultVo;
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

    @Autowired
    MallMapper mallMapper;

    @Override
    public MapResultVo queryGoods(PageUtil pageUtil, Goods goods) {
        pageUtil.initStart();
        List<Goods> data = mapper.queryGoods(pageUtil, goods);
        int count = mapper.queryGoodsCount(goods);
        return ResultUtil.ok(data, count);
    }

    @Override
    public ResultVo queryDetail(Goods goods) {
        if (goods.getId() == null) {
            return ResultUtil.fail(-1, "表单异常，id为空");
        }
        Goods goodsById = mapper.queryGoodsById(goods);
        List<GoodsAttribute> attributes = mapper.queryGoodsAttributeByConditions(goods);
        List<GoodsProduct> products = mapper.queryProductsById(goods);
        List<GoodsSpecification> specifications = mapper.queryGoodsSpecificationsById(goods);
        int id = goodsById.getCategoryId();
        int pid = mapper.queryL1CatByCid(id);
        int[] ints = {pid, id};
        Map map = new HashMap();
        map.put("categoryIds", ints);
        map.put("attributes", attributes);
        map.put("goods", goodsById);
        map.put("products", products);
        map.put("specifications", specifications);
        return ResultUtil.genSuccessResult(map);
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
