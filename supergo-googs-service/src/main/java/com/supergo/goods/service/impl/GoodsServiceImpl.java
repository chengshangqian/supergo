package com.supergo.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supergo.common.page.PageResult;
import com.supergo.goods.mapper.GoodsQueryMapper;
import com.supergo.goods.service.GoodsService;
import com.supergo.pojo.Goods;
import com.supergo.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
    // 打印日志
    public static final Logger LOGGER = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsQueryMapper goodsQueryMapper;

    @Override
    public PageResult query(Integer page, Integer size, Goods goods) {

        PageHelper.startPage(page, size);

        List<Goods> list = goodsQueryMapper.query(goods);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("list => {}", list);
        }

        PageInfo<Goods> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList(), pageInfo.getPageNum());
    }
}
