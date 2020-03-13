package com.xjtuse.mall.service;

import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ListResultVo;
import com.xjtuse.mall.utils.PageUtil;

/**
 * @author 失了秩
 * @date 2020/3/13 9:14
 * @description
 */
public interface MallService {

    ListResultVo queryCategory();

    ListResultVo queryCategoryL1();

    MapResultVo queryBrand(PageUtil pageUtil, Brand brand);
}
