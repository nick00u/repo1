package com.wmm.orders.feign;

import com.wmm.pojo.ResultVo;
import org.springframework.stereotype.Component;

@Component
public class ProductFallback implements ProductFeign {

    @Override
    public ResultVo queryByOrderId(Integer orderId) {
        return new ResultVo(true, "查询成功", null);
    }
}