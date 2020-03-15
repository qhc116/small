package com.xjtuse.mall.mapper;

import com.xjtuse.mall.bean.goods.*;
import com.xjtuse.mall.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<Goods> queryGoods(@Param("pageUtil") PageUtil pageUtil,@Param("goods") Goods goods);
    int queryGoodsCount(@Param("goods") Goods goods);

    List queryBrandForGoods();
    List queryL1CategoryForGoods();
    List queryL2CategoryForGoods(@Param("parentCategory") ParentCategory parentCategory);

    Goods queryGoodsById(@Param("goods") Goods goods);

    List<GoodsAttribute> queryGoodsAttributeByConditions(@Param("goods") Goods goods);

    List<GoodsProduct> queryProductsById(@Param("goods") Goods goods);

    List<GoodsSpecification> queryGoodsSpecificationsById(@Param("goods") Goods goods);

    int queryL1CatByCid(Integer categoryId);
}
