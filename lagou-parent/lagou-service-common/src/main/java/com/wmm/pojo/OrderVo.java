package com.wmm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderVo implements Serializable {

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 创建时间最小值
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date minTime;

    /**
     * 创建时间最大值
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maxTime;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

    /**
     * 分页开始行号
     */
    private Integer startRow;
}
