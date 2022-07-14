package com.wmm.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wmm.pojo.ProductVo;
import com.wmm.pojo.Products;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductsMapper{

    int deleteByPrimaryKey(Integer id);

    int insert(Products record);

    int insertSelective(Products record);

    Products selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Products record);

    int updateByPrimaryKey(Products record);

    /**
     * 查询所有商品分页信息
     * @param productVo
     * @return
     */
    List<Products> queryByPage(ProductVo productVo);

    /**
     * 查询所有商品分页信息总数
     * @param productVo
     * @return
     */
    Integer queryByPageTotal(ProductVo productVo);

    /**
     * 查询指定订单的商品
     * @param orderId
     * @return
     */
    List<Products> queryByOrderId(Integer orderId);

    /**
     * 查询指定订单的商品总数
     * @param orderId
     * @return
     */
    Integer queryByOrderIdTotal(Integer orderId);
}