package com.wmm.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * orders
 * @author 
 */
@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 订单号
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 订单状态
     * 0 未支付 1 已支付 2 已失效 3 已删除
     */
    private Integer status;

    private List<Products> list;
}