package com.xjtuse.mall.service;

import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.result.SingleResultVo;

/**
 * @author 失了秩
 * @date 2020/3/13 9:14
 * @description
 */
public interface MallService {

    SingleResultVo queryCategory();

    SingleResultVo queryCategoryL1();
}
