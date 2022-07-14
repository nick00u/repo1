package com.wmm.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * products
 * @author
 */
@Data
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private Double price;

    /**
     * 上架状态
     * 0 下架  1 上架
     */
    private String flag;

    /**
     * 商品描述
     */
    private String goodsDesc;

    /**
     * 商品库存
     */
    private Integer goodsStock;

    /**
     * 商品类型
     */
    private String goodsType;
}
