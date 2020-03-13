package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.bean.mall.Category;
import com.xjtuse.mall.bean.mall.ParentCategory;
import com.xjtuse.mall.mapper.MallMapper;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ListResultVo;
import com.xjtuse.mall.service.MallService;
import com.xjtuse.mall.utils.ResultUtil;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 失了秩
 * @date 2020/3/13 9:15
 * @description
 */
@Service
public class MallServiceImpl implements MallService {

    @Autowired
    MallMapper mapper;

    @Override
    public ListResultVo queryCategory() {
        List<ParentCategory> parentcategories = mapper.queryParentCategory();
        for (ParentCategory parentcategory : parentcategories) {
            List<Category> childrenCateGories = mapper.queryChildrenCategory(parentcategory);
            parentcategory.setChildren(childrenCateGories);
        }
        return ResultUtil.categoryOk(parentcategories);
    }

    @Override
    public ListResultVo queryCategoryL1() {
        List<ParentCategory> l1Categories = mapper.queryParentCategory();
        return ResultUtil.categoryOk(l1Categories);
    }

    @Override
    public MapResultVo queryBrand(PageUtil pageUtil, Brand brand) {
        if (pageUtil.getLimit() != null) {
            pageUtil.initStart();
        }


        List<Brand> data = mapper.queryBrand(pageUtil, brand);
        int count = mapper.queryBrandCount(brand);
        return ResultUtil.ok(data, count);
    }
}
