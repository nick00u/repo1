package com.wmm.orders.feign;


import com.wmm.pojo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "lagou-service-goods",fallback = ProductFallback.class)
public interface ProductFeign {

    // 查询指定订单的商品
    @GetMapping("/product/queryByOrderId/{orderId}")
    public ResultVo queryByOrderId(@PathVariable("orderId") Integer orderId);
}
