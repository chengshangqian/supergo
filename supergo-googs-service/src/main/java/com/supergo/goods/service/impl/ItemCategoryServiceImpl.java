package com.supergo.goods.service.impl;

import com.supergo.common.utils.JsonUtils;
import com.supergo.goods.service.ItemCategoryService;
import com.supergo.goods.support.RedisConstants;
import com.supergo.mapper.ItemcatMapper;
import com.supergo.pojo.Itemcat;
import com.supergo.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ItemCategoryServiceImpl extends BaseServiceImpl<Itemcat> implements ItemCategoryService {

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemCategoryServiceImpl.class);

    @Autowired
    private ItemcatMapper itemcatMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Itemcat> allItemCategories() {

        // 先从redis缓存中获取
        String itemCategories = stringRedisTemplate.opsForValue().get(RedisConstants.ITEM_CATEGORIES_ALL);

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("redis中缓存的所有商品分类: {}",itemCategories);
        }

        if(!StringUtils.isEmpty(itemCategories)){
            return JsonUtils.jsonToList(itemCategories,Itemcat.class);
        }

        // 商品分类根节点id
        Long rootId = 0L;

        // 从数据库中查询
        List<Itemcat> allItemCategories = getAllChildItemCategories(rootId);
        if(null != allItemCategories){

            // 格式化为JSON数据字符串，放入redis缓存中
            itemCategories = JsonUtils.objectToJson(allItemCategories);

            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("数据库中最新的所有商品分类: {}",itemCategories);
            }

            // TODO 缓存的更新，根据项目实际情况选择或实现以下策略
            //  1.结合商品分类的更新频率，设置有效期
            //  2.在商品分类更新时实时更新一次redis中的缓存
            //  3.调用cacheAllItemCategories手动更新缓存
            stringRedisTemplate.opsForValue().set(RedisConstants.ITEM_CATEGORIES_ALL,itemCategories);
        }

        return allItemCategories;
    }

    /**
     * 尝试从本地缓存获取，如果没有将递归调用获取子分类
     *
     * @param id 分类父节点id
     * @return 返回分类列表
     */
    private List<Itemcat> getAllChildItemCategories(Long id) {

        // 分类列表
        List<Itemcat> childCategories = childItemCategories(id);

        // 递归结束
        if (childCategories == null || childCategories.size() == 0) {
            return null;
        }

        // 遍历，递推调用或子分类列表
        childCategories.forEach(childCategory -> childCategory.setChildren(getAllChildItemCategories(childCategory.getId())));

        return childCategories;
    }

    @Override
    public List<Itemcat> childItemCategories(Long id) {
        // 查询条件
        Example example = new Example(Itemcat.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", id);

        // 分类列表
        return itemcatMapper.selectByExample(example);
    }

    @Override
    public List<Itemcat> cacheAllItemCategories() {

        // 先清除再缓存，保证数据是最新
        if(stringRedisTemplate.delete(RedisConstants.ITEM_CATEGORIES_ALL)){
            // 重新获取并缓存：缓存操作在allItemCategories方法中实现
            return this.allItemCategories();
        }

        if(LOGGER.isWarnEnabled()){
            LOGGER.warn("尝试更新所有商品列表的缓存失败...");
        }

        return null;
    }
}
