package com.lagou.products.service.impl;

import com.lagou.common.pojo.Products;
import com.lagou.products.mapper.ProductsMapper;
import com.lagou.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public int insert(Products product) {
        productsMapper.insert(product);
        return product.getId();
    }
}
