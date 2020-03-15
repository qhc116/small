package com.xjtuse.mall.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.bean.mall.Category;
import com.xjtuse.mall.bean.mall.Order;
import com.xjtuse.mall.result.*;
import com.xjtuse.mall.utils.PageUtil;
import com.xjtuse.mall.utils.ResultUtil;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author 失了秩
 * @date 2020/3/13 9:14
 * @description
 */
public interface MallService {

    ListResultVo queryCategory();

    ListResultVo queryCategoryL1();

    MapResultVo queryBrand(PageUtil pageUtil, Brand brand);

    TResultVo queryAllRegion();

    TResultVo updateBrandInfo(Brand brand);

    TResultVo deleteBrand(Brand brand);

    TResultVo uploadBrandImg(MultipartFile multipartFile);

    TResultVo createBrand(Brand brand);

    TResultVo createCategory(Category category);

    TResultVo updateCategory(Category category);

    TResultVo deleteCategory(Category category);

    MapResultVo queryOrder(PageUtil pageUtil, Order order, int[] orderStatusArray);

    int queryOrderCount(PageUtil pageUtil, Order order, int[] orderStatusArray);

    TResultVo queryOrderById(Order order);
}
