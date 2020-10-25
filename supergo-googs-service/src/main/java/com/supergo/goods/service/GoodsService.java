package com.supergo.goods.service;

import com.supergo.common.page.PageResult;
import com.supergo.pojo.Goods;
import com.supergo.service.base.BaseService;

public interface GoodsService extends BaseService<Goods> {
    PageResult query(Integer page,Integer size, Goods goods);
}
