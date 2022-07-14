package com.wmm.orders.service.impl;

import com.wmm.orders.mapper.OrdersMapper;
import com.wmm.orders.service.OrderService;
import com.wmm.pojo.OrderVo;
import com.wmm.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;


    @Override
    public Orders queryById(Integer id) {
        return ordersMapper.queryById(id);
    }

    @Override
    public List<Orders> queryByPage(OrderVo orderVo) {
        if (orderVo.getPageSize() == null || orderVo.getPageSize() < 1) {
            orderVo.setPageSize(10);
        }
        orderVo.setStartRow((orderVo.getCurrentPage() - 1) * orderVo.getPageSize());
        return ordersMapper.queryByPage(orderVo);
    }

    @Override
    public Integer queryByPageTotal(OrderVo orderVo) {
        return ordersMapper.queryByPageTotal(orderVo);
    }
}
