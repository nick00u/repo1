package com.lagou.es.service;

import com.lagou.common.pojo.Products;

public interface EsService {

    // 根据id查询商品
    Products findById(int id);
}
