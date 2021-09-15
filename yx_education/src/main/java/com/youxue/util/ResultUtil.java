package com.youxue.util;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * @author chenxi
 * @date 2021/9/7 14:39
 * @description
 */
public class ResultUtil {

    private int status;
    private String message;
    private Object data;

    public ResultUtil() {
    }

    public ResultUtil(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
