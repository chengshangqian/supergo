package com.supergo.goods.service;

import com.supergo.common.elasticsearch.SearchResult;
import com.supergo.pojo.Goods;

import java.util.Map;

public interface GoodsSearchService {
    /**
     * 使用关键字搜索商品
     *
     * @param keyword 搜索关键字
     * @param filter 其它过滤条件
     * @param page 页码
     * @param size 大小
     * @return 搜索结果
     */
    SearchResult search(String keyword, Map<String, String> filter, Integer page,Integer size);

    /**
     * 构建商品搜索索引和文档
     */
    void buildAllSearchDocuments();

    /**
     * 重建商品搜索索引和文档
     */
    void rebuildAllSearchDocuments();

    /**
     * 创建商品搜索索引,如果不存在
     */
    void putSearchIndex();

    /**
     * 删除商品搜索索引
     */
    void deleteSearchIndex();

    /**
     * 查看商品搜索索引
     */
    Map<String, Object> getSearchIndex();

    /**
     * 创建指定商品搜索文档
     *
     * @param id 商品id，也是搜索文档id
     */
    Goods createSearchDocument(Long id);

    /**
     * 删除指定商品搜索文档
     *
     * @param id 商品id
     */
    String deleteSearchDocument(String id);

    /**
     * 创建或更新指定商品搜索文档
     *
     * @param id 商品id
     */
    Goods putSearchDocument(Long id);

    /**
     * 查看指定商品搜索文档
     *
     * @param id 商品id
     */
    Goods getSearchDocument(String id);
}
