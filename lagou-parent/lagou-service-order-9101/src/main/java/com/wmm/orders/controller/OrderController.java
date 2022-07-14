package com.wmm.orders.controller;

import com.wmm.orders.feign.ProductFeign;
import com.wmm.orders.service.OrderService;
import com.wmm.pojo.OrderVo;
import com.wmm.pojo.Orders;
import com.wmm.pojo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductFeign productFeign;


    // 查询指定订单
    @GetMapping("query/{id}")
    public ResultVo getById(@PathVariable("id") Integer id) {
        ResultVo resultVo = new ResultVo();
        Orders orders = orderService.queryById(id);
        if (orders != null){
            resultVo.setSuccess(true);
            resultVo.setMessage("查询成功");
            resultVo.setContent(orders);
        }else {
            resultVo.setSuccess(false);
            resultVo.setMessage("查询失败");
        }
        return resultVo;
    }

    // 分页查询
    @PostMapping("query")
    public ResultVo getByPage(@RequestBody OrderVo orderVo) {
        ResultVo resultVo = new ResultVo();
        Map<String,Object> map = new HashMap<>();
        Integer total = orderService.queryByPageTotal(orderVo);
        List<Orders> list = orderService.queryByPage(orderVo);
        if (list != null){
            resultVo.setSuccess(true);
            resultVo.setMessage("查询成功");
            map.put("total",total);
            map.put("list",list);
            resultVo.setContent(map);
        }else {

            resultVo.setSuccess(false);
            resultVo.setMessage("查询失败");
        }
        return resultVo;
    }

    // 查询指定订单商品
    @GetMapping("queryByOrderId/{orderId}")
    public ResultVo getByOrderId(@PathVariable("orderId") Integer orderId) {
        ResultVo resultVo = productFeign.queryByOrderId(orderId);
        return resultVo;
    }
}
