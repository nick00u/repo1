package com.wmm.product.service;

import com.wmm.pojo.ProductVo;
import com.wmm.pojo.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void insert(){
        Products products = new Products();
        products.setName("iphone xs");
        products.setPrice(8000d);
        products.setFlag("1");
        products.setGoodsDesc("超强待机");
        products.setGoodsStock(100);
        products.setGoodsType("手机");
        int i = productService.insertProduct(products);
        System.out.println("i = " + i);
    }

    @Test
    public void delete(){

    }

    @Test
    public void update(){

    }

    @Test
    public void queryByPage() {

        ProductVo productVo = new ProductVo();
        productVo.setCurrentPage(1);
        productVo.setPageSize(1);
        // goodsVo.setMinPrice(3000f);
        productVo.setMinStock(100);
        List<Products> goodsList = productService.queryByPage(productVo);
        System.out.println("goodsList = " + goodsList);
    }

    @Test
    public void queryByOrderId() {

        List<Products> goodsList = productService.queryByOrderId(1);
        System.out.println("goodsList = " + goodsList);
    }
}
