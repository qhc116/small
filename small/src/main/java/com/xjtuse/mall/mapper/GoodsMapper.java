package com.xjtuse.mall.mapper;

import com.xjtuse.mall.bean.goods.Goods;
import com.xjtuse.mall.bean.user.*;
import com.xjtuse.mall.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<Goods> queryGoods(@Param("pageUtil") PageUtil pageUtil,@Param("goods") Goods goods);
    int queryGoodsCount(@Param("goods") Goods goods);
}
