package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.promotion.*;
import com.xjtuse.mall.mapper.PromotionMapper;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.TResultVo;
import com.xjtuse.mall.service.PromotionService;
import com.xjtuse.mall.utils.PageUtil;
import com.xjtuse.mall.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PromotionMapper mapper;

    @Override
    public MapResultVo queryAd(PageUtil pageUtil, Ad ad) {
        if (pageUtil.getLimit() != null) {
            pageUtil.initStart();
        }
        List<Ad> ads = mapper.queryAd(pageUtil, ad);
        int count = mapper.queryAdCount(pageUtil, ad);
        return ResultUtil.ok(ads, count);
    }

    @Override
    public TResultVo updateAd(Ad ad) {
        ad.setUpdateTime(new Date());
        mapper.updateAd(ad);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo deleteAD(Ad ad) {
        ad.setUpdateTime(new Date());
        ad.setDeleted(true);
        mapper.deleteAd(ad);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo createAd(Ad ad) {
        mapper.createAd(ad);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public MapResultVo queryCoupon(PageUtil pageUtil, Coupon coupon) {
        if (pageUtil.getLimit() != null) {
            pageUtil.initStart();
        }
        List<Coupon> coupons = mapper.queryCoupon(pageUtil, coupon);
        //检查优惠券过期情况
        int count = mapper.queryCouponCount(pageUtil, coupon);
        return ResultUtil.ok(coupons, count);
    }

    @Override
    public TResultVo queryCouponById(Coupon coupon) {
        Coupon couponById = mapper.queryCouponById(coupon);
        return ResultUtil.genSuccessResult(couponById);
    }

    @Override
    public TResultVo updateCoupon(Coupon coupon) {
        coupon.setUpdateTime(new Date());
        mapper.updateCoupon(coupon);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo deleteCoupon(Coupon coupon) {
        coupon.setUpdateTime(new Date());
        coupon.setDeleted(true);
        mapper.deleteCoupon(coupon);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo createCoupon(Coupon coupon) {
        coupon.setDeleted(false);
        mapper.createCoupon(coupon);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public MapResultVo queryCouponUser(PageUtil pageUtil, CouponAndUser couponAndUser) {
        if (pageUtil.getLimit() != null) {
            pageUtil.initStart();
        }
        List<CouponAndUser> couponAndUsers = mapper.queryCouponUser(pageUtil, couponAndUser);
        int count = mapper.queryCouponUserCount(pageUtil, couponAndUser);
        return ResultUtil.ok(couponAndUsers, count);
    }

    @Override
    public MapResultVo queryTopic(PageUtil pageUtil, Topic topic) {
        if (pageUtil.getLimit() != null) {
            pageUtil.initStart();
        }
        List<Topic> topics = mapper.queryTopic(pageUtil, topic);
        int count = mapper.queryTopicCount(pageUtil, topic);
        return ResultUtil.ok(topics, count);
    }

    @Override
    public TResultVo updateTopic(Topic topic) {
        topic.setUpdateTime(new Date());
        mapper.updateTopic(topic);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo deleteTopic(Topic topic) {
        topic.setUpdateTime(new Date());
        topic.setDeleted(true);
        mapper.deleteTopic(topic);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public TResultVo createTopic(Topic topic) {
        Date date = new Date();
        topic.setAddTime(date);
        topic.setUpdateTime(date);
        topic.setDeleted(false);
        mapper.createTopic(topic);
        return ResultUtil.genSuccessResult();
    }

    @Override
    public MapResultVo queryGroupon(PageUtil pageUtil, Groupon groupon) {
        if (pageUtil.getLimit() != null) {
            pageUtil.initStart();
        }
        List<Groupon> groupons = mapper.queryGroupon(pageUtil, groupon);
        int count = mapper.queryGrouponCount(pageUtil, groupon);
        return ResultUtil.ok(groupons, count);
    }


}
