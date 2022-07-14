package com.wmm.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVo implements Serializable {

    private boolean success;
    private String message;
    private Object content;

    public ResultVo() {
    }

    public ResultVo(boolean success, String message, Object content) {
        this.success = success;
        this.message = message;
        this.content = content;
    }
}
