package com.supergo.portal.service;

import com.supergo.common.http.HttpResult;
import com.supergo.portal.entity.SearchResult;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface SearchGoodsService {
    SearchResult search(String keyword, Map<String, String> filter, Pageable pageable);
    void importAllGoods();
}
