package com.xjtuse.mall.controller;

import com.xjtuse.mall.bean.mall.Brand;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.result.TResultVo;
import com.xjtuse.mall.service.MallService;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 失了秩
 * @date 2020/3/13 9:11
 * @description
 */
@RestController
public class MallController {

    @Autowired
    MallService mallService;

    //商品类目
    @RequestMapping("/category/list")
    public ResultVo categoryList() {
        return mallService.queryCategory();
    }

    //L1商品类目
    @RequestMapping("/category/l1")
    public ResultVo categoryL1() {
        return mallService.queryCategoryL1();
    }

    //供应商查询
    @RequestMapping("/brand/list")
    public ResultVo brandList(PageUtil pageUtil, Brand brand) {
        return mallService.queryBrand(pageUtil, brand);
    }

    //行政地区查询
    @RequestMapping("/region/list")
    public TResultVo queryAllRegion(){
        return mallService.queryAllRegion();
    }

    //更新品牌商信息
    @RequestMapping("/brand/update")
    public TResultVo updateBrandInfo(@RequestBody Brand brand){
        return mallService.updateBrandInfo(brand);
    }

    //删除品牌商
    @RequestMapping("/brand/delete")
    public TResultVo deleteBrand(@RequestBody Brand brand){
        return mallService.deleteBrand(brand);
    }

    //上传品牌商图片
    @RequestMapping("/storage/create")
    public TResultVo uploadBrand(@RequestParam("file") MultipartFile multipartFile){
        return mallService.uploadBrandImg(multipartFile);
    }

    //上传新的品牌商
    @RequestMapping("/brand/create")
    public TResultVo createBrand(@RequestBody Brand brand){
        return mallService.createBrand(brand);
    }
}
