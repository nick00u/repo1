package com.wmm.product.controller;


import com.wmm.pojo.ProductVo;
import com.wmm.pojo.Products;
import com.wmm.pojo.ResultVo;
import com.wmm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 查询指定商品
    @GetMapping("query/{id}")
    public ResultVo queryById(@PathVariable("id") Integer id){
        ResultVo resultVo = new ResultVo();
        Products products = productService.queryById(id);
        if(products != null){
            resultVo.setSuccess(true);
            resultVo.setMessage("查询成功");
            resultVo.setContent(products);
        }else {
            resultVo.setSuccess(false);
            resultVo.setMessage("查询失败");
        }

        return resultVo;
    }

    // 删除指定商品
    @DeleteMapping("delete/{id}")
    public ResultVo deleteById(@PathVariable("id") Integer id){
        ResultVo resultVo = new ResultVo();
        int i = productService.deleteById(id);
        if(i !=0){
            resultVo.setSuccess(true);
            resultVo.setMessage("删除成功");
        }else {
            resultVo.setSuccess(false);
            resultVo.setMessage("删除失败");
        }
        return resultVo;
    }

    // 新增或修改商品信息
    @PostMapping("saveOrUpdate")
    public ResultVo saveOrUpdate(@RequestBody Products products){
        ResultVo resultVo = new ResultVo();
        if (products.getId() == null) {
            int i = productService.insertProduct(products);
            if(i !=0){
                resultVo.setSuccess(true);
                resultVo.setMessage("新增成功");
            }else {
                resultVo.setSuccess(false);
                resultVo.setMessage("新增失败");
            }
        } else {
            int i = productService.updateProducts(products);
            if(i !=0){
                resultVo.setSuccess(true);
                resultVo.setMessage("修改成功");
            }else {
                resultVo.setSuccess(false);
                resultVo.setMessage("修改失败");
            }
        }
        return resultVo;
    }

    // 查询指定条件的商品信息
    @PostMapping("queryByPage")
    public ResultVo queryByPage(@RequestBody ProductVo productVo){
        Map<String,Object> map = new HashMap<>();
        ResultVo resultVo = new ResultVo();
        Integer total = productService.queryByPageTotal(productVo);
        List<Products> list = productService.queryByPage(productVo);
        if (list != null){
            resultVo.setSuccess(true);
            resultVo.setMessage("查询成功");
            map.put("list",list);
            map.put("total",total);
            resultVo.setContent(map);
        }else{
            resultVo.setSuccess(false);
            resultVo.setMessage("查询失败");
        }
        return resultVo;
    }

    // 查询指定订单商品信息
    @GetMapping("queryByOrderId/{orderId}")
    public ResultVo queryByOrderId(@PathVariable("orderId") Integer orderId){
        try {
            Thread.sleep(10*1000); // 休眠 10s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String,Object> map = new HashMap<>();
        ResultVo resultVo = new ResultVo();
        Integer total = productService.queryByOrderIdTotal(orderId);
        List<Products> list = productService.queryByOrderId(orderId);
        if (list != null){
            resultVo.setSuccess(true);
            resultVo.setMessage("查询成功");
            map.put("list",list);
            map.put("total",total);
            resultVo.setContent(map);
        }else{
            resultVo.setSuccess(false);
            resultVo.setMessage("查询失败");
        }
        return resultVo;
    }
}
