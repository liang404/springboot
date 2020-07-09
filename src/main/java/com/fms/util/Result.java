package com.fms.util;

/**
 * @author liang
 * @create 2020/6/27 17:00
 */
public class Result<T> {
    private Integer status;
    private T items;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }
}
