package com.supergo.goods.service;

import com.supergo.pojo.Itemcat;

import java.util.List;

/**
 * 商品分类
 */
public interface ItemcatService {
    /**
     * 获取商品分类
     *
     * @return 返回分类列表
     */
    List<Itemcat> categories();
}
