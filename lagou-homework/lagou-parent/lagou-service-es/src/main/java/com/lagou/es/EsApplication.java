package com.lagou.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lagou.es.mapper")
public class EsApplication {

    public static void main(String[] args) {

        SpringApplication.run(EsApplication.class, args);
    }
}
