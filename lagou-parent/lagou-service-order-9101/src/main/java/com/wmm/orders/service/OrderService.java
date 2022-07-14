package com.wmm.orders.service;

import com.wmm.pojo.OrderVo;
import com.wmm.pojo.Orders;

import java.util.List;

public interface OrderService {

    /**
     * 查询指定订单信息
     * @param id
     * @return
     */
    public Orders queryById(Integer id);

    /**
     * 查询指定条件订单信息
     */
    public List<Orders> queryByPage(OrderVo orderVo);

    /**
     * 查询指定条件订单信息总数
     * @param orderVo
     * @return
     */
    public Integer queryByPageTotal(OrderVo orderVo);
}
