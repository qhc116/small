package com.xjtuse.mall.mapper;

import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.bean.mall.Category;
import com.xjtuse.mall.bean.mall.ParentCategory;
import com.xjtuse.mall.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 失了秩
 * @date 2020/3/13 9:16
 * @description
 */
public interface MallMapper {
    List<ParentCategory> queryParentCategory();
    List<Category> queryChildrenCategory(@Param("parentCategory") ParentCategory parentCategory);

    List<Brand> queryBrand(@Param("pageUtil") PageUtil pageUtil,@Param("brand")  Brand brand);
    int queryBrandCount(@Param("brand") Brand brand);
}
