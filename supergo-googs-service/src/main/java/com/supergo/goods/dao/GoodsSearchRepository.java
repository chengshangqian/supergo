package com.supergo.goods.dao;

import com.supergo.pojo.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 继承ElasticsearchRepository，指定实体SearchGoods
 * 如果实体类有ES的注解，比如@Document，SpringBoot启动时会自动创建索引和映射
 */
// @Repository // 可以不需要声明仓库注解
public interface GoodsSearchRepository extends ElasticsearchRepository<Goods, Long> {
    /**
     * 根据商品名称或副标题描述搜索商品
     *
     * @param goodsName 商品名称
     * @param caption 副标题
     * @param pageable 分页，封装了排序
     * @return 返回分页信息和商品集合
     */
    @Highlight(
            // 高亮字段，name对应实体中的属性名称
            fields={
                    @HighlightField(name="goodsName"),
                    @HighlightField(name="caption")
            },
            // 高亮参数：比如设置匹配的搜索关键字颜色、粗细等
            parameters = @HighlightParameters(preTags={"<font color=\"red\"><em>"},postTags = {"</em></font>"})
    )
    Page<Goods> findByGoodsNameOrCaption(String goodsName,String caption,Pageable pageable);

    /**
     * 商品名称搜索，分页（包含额外的搜索信息、聚合信息等）
     *
     * @param goodsName 商品名称
     * @param pageable 分页
     * @return 返回分页信息和商品集合之外，还包含了聚合信息、搜索（得分、命中等）信息
     */
    SearchPage<Goods> findByGoodsName(String goodsName, Pageable pageable);

    /**
     * 商家名称搜索，排序
     *
     * @param nickName 商家名称
     * @param sort 排序
     * @return 返回商品集合
     */
    List<Goods> findByNickName(String nickName, Sort sort);

    /**
     * 根据品牌名称属性搜索
     *
     * @param brandName 品牌名称
     * @return 返回商品集合
     */
    List<Goods> findByBrandName(String brandName);

    /**
     * 根据类目三名称属性搜索
     *
     * @param category3Name 类目三名称
     * @return 返回商品集合
     */
    List<Goods> findByCategory3Name(String category3Name);

    /**
     * 搜索使用指定名称开头的商品
     *
     * @param goodsName 商品名称
     * @return 包含搜索信息的商品集合
     */
    List<SearchHit<Goods>> findByGoodsNameStartingWith(String goodsName);


    /**
     * 使用@Query：搜索商品名称. 使用[?参数位置]来注入搜索关键字
     *
     * @param goodsName 商品名称
     * @return 商品集合
     */
    @Query("{\"multi_match\":{\"query\":\"?0\",\"fields\":\"goodsName\"}}")
    List<Goods> query(String goodsName);


    /**
     * 使用@Query：搜索商品名称，分页
     *
     * @param goodsName 商品名称
     * @return 商品集合
     */
    @Query("{\"multi_match\":{\"query\":\"?0\",\"fields\":\"goodsName\"}}")
    Page<Goods> queryPage(String goodsName, Pageable pageable);
}
