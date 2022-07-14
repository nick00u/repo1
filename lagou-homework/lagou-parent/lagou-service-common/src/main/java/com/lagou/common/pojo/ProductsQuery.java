package com.lagou.common.pojo;

import lombok.Data;

/**
 * 封装商品查询条件
 */
@Data
public class ProductsQuery {

    private Integer currentPage;  // 当前页
    private Integer pageSize;  // 页大小

    private String name;  // 商品名称（查询条件）

    private Double priceLow;  // 价格下限
    private Double priceHigh;  // 价格上限
}
