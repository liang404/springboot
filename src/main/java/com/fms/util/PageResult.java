package com.fms.util;

import java.util.List;

/**
 * @author liang
 * @create 2020/6/25 22:30
 */
public class PageResult<T> {

    private Long total ;//总记录数
    private Integer totalPage;//总页数
    private List<T> items;//数据

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "rivate=" + total +
                ", totalPage=" + totalPage +
                ", items=" + items +
                '}';
    }
}
