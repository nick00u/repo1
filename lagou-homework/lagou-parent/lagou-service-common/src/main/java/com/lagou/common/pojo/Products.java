package com.lagou.common.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@TableName("products")
@Document(indexName = "lagou", type = "product")
public class Products {

    @Id
    private int id;
    private String name;
    private Double price;
    private String flag;
    private String goodsDesc;
    private String images;
    private Integer goodsStock;
    private String goodsType;

}