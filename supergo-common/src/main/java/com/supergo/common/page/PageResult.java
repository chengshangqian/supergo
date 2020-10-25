package com.supergo.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 */
public class PageResult implements Serializable {

    private Long total;

    private Integer page = 1;

    private Integer size = 10;

    private List<?> list;

    public PageResult() {
    }

    public PageResult(Long total, List<?> list) {
        this.total = total;
        this.list = list;
    }

    public PageResult(Long total, List<?> list, Integer page) {
        this.total = total;
        this.list = list;
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", page=" + page +
                ", list=" + list +
                ", size=" + size +
                '}';
    }
}
