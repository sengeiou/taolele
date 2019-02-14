package com.cjw.taolele.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private List<T> rows;   //当前页的数据集合
    private Long total;     //总数据条数

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
