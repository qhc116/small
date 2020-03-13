package com.xjtuse.mall.service;

import com.xjtuse.mall.bean.goods.Goods;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.utils.PageUtil;

/**
 * @author 失了秩
 * @date 2020/3/12 22:57
 * @description
 */
public interface GoodsService {

    ResultVo queryGoods(PageUtil pageUtil, Goods goods);

    ResultVo queryDetail(Goods goods);

    ResultVo queryCatAndBrand();
}
