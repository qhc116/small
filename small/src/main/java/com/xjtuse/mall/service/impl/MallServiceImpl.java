package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.bean.mall.Category;
import com.xjtuse.mall.bean.mall.ParentCategory;
import com.xjtuse.mall.common.Constants;
import com.xjtuse.mall.mapper.MallMapper;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ListResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.result.TResultVo;
import com.xjtuse.mall.service.MallService;
import com.xjtuse.mall.utils.MD5Util;
import com.xjtuse.mall.utils.ResultUtil;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

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

    @Override
    public TResultVo queryAllRegion() {
        return ResultUtil.genSuccessResult(mapper.queryAllRegion());
    }

    @Override
    public TResultVo updateBrandInfo(Brand brand) {
        //更新操作日期
        brand.setUpdateTime(new Date());
        mapper.updateBrandInfo(brand);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo deleteBrand(Brand brand) {
        mapper.deleteBrand(brand);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo uploadBrandImg(MultipartFile multipartFile) {
        //写入文件到/resources/static中
        String fileName = null;
        try {

            String[] split = multipartFile.getOriginalFilename().split("\\.");
            fileName = MD5Util.MD5Encode(split[0], "UTF-8") + "." + split[1];
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(Constants.ROOT_PATH,
                    Constants.RELATIVE_PATH,
                    fileName);
            Files.write(path, bytes);
            //返回url数据
            HashMap<String, String> map = new HashMap<>();
            map.put("url", Constants.IMG_URL + fileName);
            return ResultUtil.genSuccessResult(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TResultVo createBrand(Brand brand) {
        brand.setUpdateTime(new Date());
        brand.setAddTime(new Date());
        mapper.createBrand(brand);
        return ResultUtil.genSuccessResult();
    }
}
