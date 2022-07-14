package com.lagou.es.repository;

import com.lagou.common.pojo.Products;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

// 当使用SDE访问索引库时，需要定义一个接口去继承ElasticsearchRepository接口，无需实现
public interface ProductsRepository extends ElasticsearchRepository<Products, Long> {
}
