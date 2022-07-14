package com.wmm.product;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication9201 {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication9201.class,args);
    }
}
