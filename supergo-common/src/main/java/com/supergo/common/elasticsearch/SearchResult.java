package com.supergo.common.elasticsearch;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索结果
 *
 * @param <T>
 */
public class SearchResult<T> implements Serializable {
    private List<T> results;
    private List<?> aggs;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public List<?> getAggs() {
        return aggs;
    }

    public void setAggs(List<?> aggs) {
        this.aggs = aggs;
    }
}
