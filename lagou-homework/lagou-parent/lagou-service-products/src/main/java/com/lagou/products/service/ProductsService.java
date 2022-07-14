package com.lagou.products.service;

import com.lagou.common.pojo.Products;

public interface ProductsService {

    /**
     * 插入商品，返回商品id
     * @param product
     * @return
     */
    int insert(Products product);
}
