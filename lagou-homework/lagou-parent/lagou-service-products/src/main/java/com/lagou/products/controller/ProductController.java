package com.lagou.products.controller;

import com.lagou.common.elasticsearch.ESSearchResultMapper;
import com.lagou.common.pojo.Products;
import com.lagou.common.pojo.ProductsQuery;
import com.lagou.products.service.ProductsService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    // 保存商品信息
    @PostMapping("/save")
    public String save(@RequestBody Products product) {
        String productId = String.valueOf(productsService.insert(product));
        //发送消息至product主题中，自动序列化
        kafkaTemplate.send("product", productId);

        return productId;
    }

    // 商品查询
    @PostMapping("/findProducts")
    public List<Products> findProducts(@RequestBody ProductsQuery productsQuery) {

        // 构建一个原生查询器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", productsQuery.getName()));
        // 设置分页和排序规则
        queryBuilder.withPageable(
                PageRequest.of(
                        productsQuery.getCurrentPage()-1,
                        productsQuery.getPageSize(),
                        Sort.by(Sort.Direction.ASC, "price")));
        // 高亮
        HighlightBuilder.Field field = new HighlightBuilder.Field("name");
        field.preTags("<font style='color:red'>");
        field.postTags("</font>");
        queryBuilder.withHighlightFields(field);
        // 过滤价格范围
        RangeQueryBuilder filterBuilder = QueryBuilders.rangeQuery("price");
        filterBuilder.gte(productsQuery.getPriceLow());
        filterBuilder.lte(productsQuery.getPriceHigh());
        queryBuilder.withFilter(filterBuilder);
        // 查询
        AggregatedPage<Products> products = esTemplate.queryForPage(queryBuilder.build(), Products.class, new ESSearchResultMapper());
        // 获得本页的数据集合
        return products.getContent();
    }
}
