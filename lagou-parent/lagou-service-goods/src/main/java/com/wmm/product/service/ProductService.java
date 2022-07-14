package com.wmm.product.service;

import com.wmm.pojo.ProductVo;
import com.wmm.pojo.Products;

import java.util.List;

public interface ProductService {

    /**
     * 新增商品
     * @param products
     */
    public int insertProduct(Products products);

    /**
     * 删除商品
     * @param id
     */
    public int deleteById(Integer id);

    /**
     * 修改商品
     * @param products
     */
    public int updateProducts(Products products);

    /**
     * 查询指定商品
     * @param id
     * @return
     */
    public Products queryById(Integer id);

    /**
     * 查询所有商品分页信息
     * @param productVo 查询条件
     * @return
     */
    public List<Products> queryByPage(ProductVo productVo);

    /**
     * 查询指定订单的商品
     * @param orderId
     * @return
     */
    public List<Products> queryByOrderId(Integer orderId);

    /**
     * 查询所有商品分页信息总数
     * @param productVo
     * @return
     */
    public Integer queryByPageTotal(ProductVo productVo);

    /**
     * 查询指定订单的商品总数
     * @param orderId
     * @return
     */
    public Integer queryByOrderIdTotal(Integer orderId);

}
