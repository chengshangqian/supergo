package com.supergo.goods.service.impl;

import com.supergo.common.utils.JsonUtils;
import com.supergo.goods.service.ItemcatService;
import com.supergo.mapper.ItemcatMapper;
import com.supergo.pojo.Item;
import com.supergo.pojo.Itemcat;
import com.supergo.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ItemcatServiceImpl extends BaseServiceImpl<Item> implements ItemcatService {

    @Autowired
    private ItemcatMapper itemcatMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // redis缓存
    public static final String REDIS_DATA_SUPERGO_ITEM_CATEGORIES = "redis-data-supergo-item-categories";

    // ES搜索引擎索引id
    public static final String ES_DATA_SUPERGO_ITEM_CATEGORIES = "elasticsearch-data-supergo-item-categories";

    /**
     * 先从redis缓存中获取
     *
     * @return 商品分类列表
     */
    @Override
    public List<Itemcat> categories() {
        String categories = stringRedisTemplate.opsForValue().get(REDIS_DATA_SUPERGO_ITEM_CATEGORIES);
        if(!StringUtils.isEmpty(categories)){
            return JsonUtils.jsonToList(categories,Itemcat.class);
        }

        List<Itemcat> list = getChildCategories(0);
        if(null != list){
            categories = JsonUtils.objectToJson(list);
            // 放入缓存中
            stringRedisTemplate.opsForValue().set(REDIS_DATA_SUPERGO_ITEM_CATEGORIES,categories);
        }
        return list;
    }

    /**
     * 尝试从本地缓存获取，如果没有将递归调用获取子分类
     *
     * @param parentId 父类id
     * @return 返回分类列表
     */
    private List<Itemcat> getChildCategories(long parentId) {
        // 查询条件
        Example example = new Example(Itemcat.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", parentId);

        // 分类列表
        List<Itemcat> list = itemcatMapper.selectByExample(example);

        // 递归结束
        if (list == null || list.size() == 0) {
            return null;
        }

        // 遍历，递推调用或子分类列表
        list.forEach(itemcat -> itemcat.setChildren(getChildCategories(itemcat.getId())));

        return list;
    }
}
