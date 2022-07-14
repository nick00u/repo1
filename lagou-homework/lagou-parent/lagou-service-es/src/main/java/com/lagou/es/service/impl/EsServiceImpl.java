package com.lagou.es.service.impl;

import com.lagou.common.pojo.Products;
import com.lagou.es.mapper.EsMapper;
import com.lagou.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsServiceImpl implements EsService {

    @Autowired
    private EsMapper esMapper;


    @Override
    public Products findById(int id) {
        return esMapper.selectById(id);
    }
}
