package com.supergo.goods.service;

import com.supergo.pojo.Itemcat;
import com.supergo.service.base.BaseService;

import java.util.List;

/**
 * 商品分类
 */
public interface ItemCategoryService extends BaseService<Itemcat> {
    /**
     * 获取所有商品分类
     *
     * @return 返回商品分类列表
     */
    List<Itemcat> allItemCategories();

    /**
     * 获取下一层商品分类列表
     *
     * @param id 当前分类id
     * @return
     */
    List<Itemcat> childItemCategories(Long id);

    /**
     * 缓存并获取所有商品分类列表
     *
     * @return
     */
    List<Itemcat> cacheAllItemCategories();
}
