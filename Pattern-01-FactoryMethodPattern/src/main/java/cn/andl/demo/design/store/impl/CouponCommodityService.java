package cn.andl.demo.design.store.impl;

import cn.andl.demo.design.coupon.CouponResult;
import cn.andl.demo.design.coupon.CouponService;
import cn.andl.demo.design.store.ICommodity;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CouponCommodityService implements ICommodity {
    private final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    private final CouponService couponService = new CouponService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}