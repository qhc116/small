package com.xjtuse.mall.service;

import com.xjtuse.mall.bean.promotion.*;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.TResultVo;
import com.xjtuse.mall.utils.PageUtil;

public interface PromotionService {

    MapResultVo queryAd(PageUtil pageUtil, Ad ad);

    TResultVo updateAd(Ad ad);

    TResultVo deleteAD(Ad ad);

    TResultVo createAd(Ad ad);

    MapResultVo queryCoupon(PageUtil pageUtil, Coupon coupon);

    TResultVo queryCouponById(Coupon coupon);

    TResultVo updateCoupon(Coupon coupon);

    TResultVo deleteCoupon(Coupon coupon);

    TResultVo createCoupon(Coupon coupon);

    MapResultVo queryCouponUser(PageUtil pageUtil, CouponAndUser couponAndUser);

    MapResultVo queryTopic(PageUtil pageUtil, Topic topic);

    TResultVo updateTopic(Topic topic);

    TResultVo deleteTopic(Topic topic);

    TResultVo createTopic(Topic topic);

    MapResultVo queryGroupon(PageUtil pageUtil, Groupon groupon);
}
