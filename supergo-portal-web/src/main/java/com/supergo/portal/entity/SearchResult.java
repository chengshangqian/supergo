package com.supergo.portal.entity;

import java.io.Serializable;
import java.util.List;

public class SearchResult<T> implements Serializable {
    private List<T> resultList;
    private List<?> aggs;

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public List<?> getAggs() {
        return aggs;
    }

    public void setAggs(List<?> aggs) {
        this.aggs = aggs;
    }
}
