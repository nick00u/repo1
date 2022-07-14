package com.wmm.orders.mapper;

import com.wmm.pojo.OrderVo;
import com.wmm.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {

    /**
     * 查询指定订单信息
     * @param id
     * @return
     */
    Orders queryById(Integer id);

    /**
     * 查询指定条件订单信息
     */
    List<Orders> queryByPage(OrderVo orderVo);


    Integer queryByPageTotal(OrderVo orderVo);
}