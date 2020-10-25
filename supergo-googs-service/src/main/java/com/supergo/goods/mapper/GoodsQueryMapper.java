package com.supergo.goods.mapper;

import com.supergo.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsQueryMapper {
    @SelectProvider(type = GoodsQueryProvider.class, method = "query")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "goods_name", property = "goodsName"),
            @Result(column = "default_item_id", property = "defaultItemId"),
            @Result(column = "audit_status", property = "auditStatus"),
            @Result(column = "is_marketable", property = "isMarketable"),
            @Result(column = "brand_id", property = "brandId"),
            @Result(column = "caption", property = "caption"),
            @Result(column = "category1_id", property = "category1Id"),
            @Result(column = "category2_id", property = "category2Id"),
            @Result(column = "category3_id", property = "category3Id"),
            @Result(column = "small_pic", property = "smallPic"),
            @Result(column = "price", property = "price"),
            @Result(column = "type_template_id", property = "typeTemplateId"),
            @Result(column = "is_enable_spec", property = "isEnableSpec"),
            @Result(column = "is_delete", property = "isDelete"),
            @Result(column = "seller_id", property = "nickName", one = @One(select = "selectSellerName")),
            @Result(column = "brand_id", property = "brandName", one = @One(select = "selectBrandName")),
            @Result(column = "category1_id", property = "category1Name", one = @One(select = "selectCategoryName")),
            @Result(column = "category2_id", property = "category2Name", one = @One(select = "selectCategoryName")),
            @Result(column = "category3_id", property = "category3Name", one = @One(select = "selectCategoryName"))
    })
    List<Goods> query(Goods goods);

    @Select("SELECT nick_name FROM tb_seller WHERE seller_id = #{id}")
    String selectSellerName(String id);

    @Select("SELECT name FROM tb_brand WHERE id = #{id}")
    String selectBrandName(Long id);

    @Select("SELECT name FROM tb_item_cat WHERE id = #{id}")
    String selectCategoryName(Long id);
}
