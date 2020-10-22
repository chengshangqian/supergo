package com.supergo.portal.dao;

import com.supergo.portal.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 继承ElasticsearchRepository，指定实体Product
 * 如果实体类有ES的注解，比如@Document，SpringBoot启动时会自动创建索引和映射
 */
// @Repository // 可以不需要声明仓库注解
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
    // 一个查询关键字对应itemName和itemDesc
    Page<Item> findByItemNameOrItemDesc(String itemName,String itemDesc , Pageable pageable);
}
