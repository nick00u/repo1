package com.wmm.product.mapper;

import com.wmm.pojo.Products;
import com.wmm.product.mapper.ProductsMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class ProductsMapperTest {

    @Autowired
    private ProductsMapper productsMapper;

    @org.junit.Test
    public void query(){
        Integer integer = productsMapper.queryByOrderIdTotal(1);
        System.out.println("integer = " + integer);
    }
}
