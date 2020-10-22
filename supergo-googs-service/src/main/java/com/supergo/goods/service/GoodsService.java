package com.supergo.goods.service;

import com.supergo.pojo.Goods;
import com.supergo.service.base.BaseService;

import java.util.List;

public interface GoodsService extends BaseService<Goods> {
    List<Goods> search(Goods goods);
    Goods get(Long id);
}
