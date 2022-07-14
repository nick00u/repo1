package com.wmm.product.service.impl;

import com.wmm.pojo.ProductVo;
import com.wmm.pojo.Products;
import com.wmm.product.mapper.ProductsMapper;
import com.wmm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public int insertProduct(Products products) {
        return productsMapper.insert(products);
    }

    @Override
    public int deleteById(Integer id) {

        return productsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateProducts(Products products) {
        return productsMapper.updateByPrimaryKeySelective(products);
    }

    @Override
    public Products queryById(Integer id) {
        Products products = productsMapper.selectByPrimaryKey(id);
        return products;
    }

    @Override
    public List<Products> queryByPage(ProductVo productVo) {
        if (productVo.getPageSize() == null || productVo.getPageSize() < 1) {
            productVo.setPageSize(10);
        }
        productVo.setStartRow((productVo.getCurrentPage() - 1) * productVo.getPageSize());
        return productsMapper.queryByPage(productVo);
    }

    @Override
    public List<Products> queryByOrderId(Integer orderId) {
        return productsMapper.queryByOrderId(orderId);
    }

    @Override
    public Integer queryByPageTotal(ProductVo productVo) {
        return productsMapper.queryByPageTotal(productVo);
    }

    @Override
    public Integer queryByOrderIdTotal(Integer orderId) {
        return productsMapper.queryByOrderIdTotal(orderId);
    }
}
