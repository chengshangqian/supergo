package com.supergo.common.page;

import java.io.Serializable;

/**
 * 分页请求
 */
public class PageRequest implements Serializable{

    private Integer page = 1;

    private Integer size = 10;

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
}
