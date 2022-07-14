package com.wmm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductVo implements Serializable {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品分类
     */
    private String catalog;

    /**
     * 价格最小值
     */
    private double minPrice;

    /**
     * 价格最大值
     */
    private double maxPrice;

    /**
     * 库存最小值
     */
    private Integer minStock;

    /**
     * 库存最大值
     */
    private Integer maxStock;

    /**
     * 上架状态
     */
    private Integer status;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

    /**
     * 分页开始行号
     */
    private Integer startRow;

}
