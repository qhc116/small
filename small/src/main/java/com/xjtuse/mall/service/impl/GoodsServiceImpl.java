package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.goods.Goods;
import com.xjtuse.mall.mapper.GoodsMapper;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.GoodsService;
import com.xjtuse.mall.utils.MutiResultVoUtil;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResultVo queryGoods(PageUtil pageUtil, Goods goods) {
        pageUtil.initStart();
        List<Goods> data = mapper.queryGoods(pageUtil, goods);
        int count = mapper.queryGoodsCount(goods);
        return MutiResultVoUtil.ok(data, count);
    }

    @Override
    public ResultVo queryDetail(Goods goods) {
        return null;
    }
}
