package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.mall.Category;
import com.xjtuse.mall.bean.mall.ParentCategory;
import com.xjtuse.mall.mapper.MallMapper;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.result.SingleResultVo;
import com.xjtuse.mall.service.MallService;
import com.xjtuse.mall.utils.MutiResultVoUtil;
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
    public SingleResultVo queryCategory() {
        List<ParentCategory> parentcategories = mapper.queryParentCategory();
        for (ParentCategory parentcategory : parentcategories) {
            List<Category> childrenCateGories = mapper.queryChildrenCategory(parentcategory);
            parentcategory.setChildren(childrenCateGories);
        }
        return MutiResultVoUtil.categoryOk(parentcategories);
    }

    @Override
    public SingleResultVo queryCategoryL1() {
        List<ParentCategory> l1Categories = mapper.queryParentCategory();
        return MutiResultVoUtil.categoryOk(l1Categories);
    }
}
