package cn.andl.demo.design;

import cn.andl.demo.design.store.ICommodity;
import cn.andl.demo.design.store.impl.CardCommodityService;
import cn.andl.demo.design.store.impl.CouponCommodityService;
import cn.andl.demo.design.store.impl.GoodsCommodityService;

public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) {
            return null;
        }

        switch (commodityType) {
            case 1:
                return new CouponCommodityService();
            case 2:
                return new GoodsCommodityService();
            case 3:
                return new CardCommodityService();
        }

        throw new RuntimeException("不存在的商品服务类型");
    }

}
