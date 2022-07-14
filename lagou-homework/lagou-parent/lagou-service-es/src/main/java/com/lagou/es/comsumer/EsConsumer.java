package com.lagou.es.comsumer;

import com.lagou.common.pojo.Products;
import com.lagou.es.repository.ProductsRepository;
import com.lagou.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EsConsumer {

    @Autowired
    private EsService esService;

    @Autowired
    private ProductsRepository productsRepository;

    // 配置KafkaListener后持续监听product主题
    @KafkaListener(topics = {"product"})
    public void savePruduct(String id) {

        // 将接收到的id转换为int类型
        int productId = Integer.parseInt(id);

        //调用service层通过id查询商品方法
        Products product = esService.findById(productId);

        // 添加索引数据
        productsRepository.save(product);
    }
}
