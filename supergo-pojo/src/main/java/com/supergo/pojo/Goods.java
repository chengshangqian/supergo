package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="com.supergo.pojo.Goods")
@Table(name = "tb_goods")
@Document(indexName = "goods")
public class Goods implements Serializable {

/***************************** 扩充属性start ******************************/
    /**
     * 商家名称
     */
    @Transient
    @ApiModelProperty(value="商家名称")
    @Field(type = FieldType.Keyword)
    private String nickName;

    /**
     * 品牌名称
     */
    @Transient
    @ApiModelProperty(value="品牌名称")
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 一级类目名称
     */
    @Transient
    @ApiModelProperty(value="一级类目名称")
    @Field(type = FieldType.Keyword)
    private String category1Name;

    /**
     * 二级类目名称
     */
    @Transient
    @ApiModelProperty(value="二级类目名称")
    @Field(type = FieldType.Keyword)
    private String category2Name;

    /**
     * 三级类目名称
     */
    @Transient
    @ApiModelProperty(value="三级类目名称")
    @Field(type = FieldType.Keyword)
    private String category3Name;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategory1Name() {
        return category1Name;
    }

    public void setCategory1Name(String category1Name) {
        this.category1Name = category1Name;
    }

    public String getCategory2Name() {
        return category2Name;
    }

    public void setCategory2Name(String category2Name) {
        this.category2Name = category2Name;
    }

    public String getCategory3Name() {
        return category3Name;
    }

    public void setCategory3Name(String category3Name) {
        this.category3Name = category3Name;
    }

    /***************************** 扩充属性end ******************************/

    /**
     * 主键
     */
    @Id
    @ApiModelProperty(value="id主键")
    @Field(type = FieldType.Long)
    private Long id;

    /**
     * 商家ID
     */
    @Column(name = "seller_id")
    @ApiModelProperty(value="sellerId商家ID")
    @Field(type = FieldType.Keyword)
    private String sellerId;

    /**
     * SPU名
     */
    @Column(name = "goods_name")
    @ApiModelProperty(value="goodsNameSPU名")
    @Field(type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String goodsName;

    /**
     * 默认SKU
     */
    @Column(name = "default_item_id")
    @ApiModelProperty(value="defaultItemId默认SKU")
    @Field(type = FieldType.Long)
    private Long defaultItemId;

    /**
     * 状态
     */
    @Column(name = "audit_status")
    @ApiModelProperty(value="auditStatus状态")
    @Field(type = FieldType.Keyword)
    private String auditStatus;

    /**
     * 是否上架
     */
    @Column(name = "is_marketable")
    @ApiModelProperty(value="isMarketable是否上架")
    @Field(type = FieldType.Keyword)
    private String isMarketable;

    /**
     * 品牌
     */
    @Column(name = "brand_id")
    @ApiModelProperty(value="brandId品牌")
    @Field(type = FieldType.Long)
    private Long brandId;

    /**
     * 副标题
     */
    @ApiModelProperty(value="caption副标题")
    @Field(type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String caption;

    /**
     * 一级类目
     */
    @Column(name = "category1_id")
    @ApiModelProperty(value="category1Id一级类目")
    @Field(type = FieldType.Long)
    private Long category1Id;

    /**
     * 二级类目
     */
    @Column(name = "category2_id")
    @ApiModelProperty(value="category2Id二级类目")
    @Field(type = FieldType.Long)
    private Long category2Id;

    /**
     * 三级类目
     */
    @Column(name = "category3_id")
    @ApiModelProperty(value="category3Id三级类目")
    @Field(type = FieldType.Long)
    private Long category3Id;

    /**
     * 小图
     */
    @Column(name = "small_pic")
    @ApiModelProperty(value="smallPic小图")
    @Field(type = FieldType.Keyword)
    private String smallPic;

    /**
     * 商城价
     */
    @ApiModelProperty(value="price商城价")
    @Field(type = FieldType.Scaled_Float)
    private BigDecimal price;

    /**
     * 分类模板ID
     */
    @Column(name = "type_template_id")
    @ApiModelProperty(value="typeTemplateId分类模板ID")
    @Field(type = FieldType.Long)
    private Long typeTemplateId;

    /**
     * 是否启用规格
     */
    @Column(name = "is_enable_spec")
    @ApiModelProperty(value="isEnableSpec是否启用规格")
    @Field(type = FieldType.Keyword)
    private String isEnableSpec;

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    @ApiModelProperty(value="isDelete是否删除")
    @Field(type = FieldType.Keyword)
    private String isDelete;

    private static final long serialVersionUID = 1L;

    public Goods(Long id, String sellerId, String goodsName, Long defaultItemId, String auditStatus, String isMarketable, Long brandId, String caption, Long category1Id, Long category2Id, Long category3Id, String smallPic, BigDecimal price, Long typeTemplateId, String isEnableSpec, String isDelete) {
        this.id = id;
        this.sellerId = sellerId;
        this.goodsName = goodsName;
        this.defaultItemId = defaultItemId;
        this.auditStatus = auditStatus;
        this.isMarketable = isMarketable;
        this.brandId = brandId;
        this.caption = caption;
        this.category1Id = category1Id;
        this.category2Id = category2Id;
        this.category3Id = category3Id;
        this.smallPic = smallPic;
        this.price = price;
        this.typeTemplateId = typeTemplateId;
        this.isEnableSpec = isEnableSpec;
        this.isDelete = isDelete;
    }

    public Goods() {
        super();
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商家ID
     *
     * @return seller_id - 商家ID
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 设置商家ID
     *
     * @param sellerId 商家ID
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取SPU名
     *
     * @return goods_name - SPU名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置SPU名
     *
     * @param goodsName SPU名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取默认SKU
     *
     * @return default_item_id - 默认SKU
     */
    public Long getDefaultItemId() {
        return defaultItemId;
    }

    /**
     * 设置默认SKU
     *
     * @param defaultItemId 默认SKU
     */
    public void setDefaultItemId(Long defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    /**
     * 获取状态
     *
     * @return audit_status - 状态
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置状态
     *
     * @param auditStatus 状态
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取是否上架
     *
     * @return is_marketable - 是否上架
     */
    public String getIsMarketable() {
        return isMarketable;
    }

    /**
     * 设置是否上架
     *
     * @param isMarketable 是否上架
     */
    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    /**
     * 获取品牌
     *
     * @return brand_id - 品牌
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌
     *
     * @param brandId 品牌
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取副标题
     *
     * @return caption - 副标题
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 设置副标题
     *
     * @param caption 副标题
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 获取一级类目
     *
     * @return category1_id - 一级类目
     */
    public Long getCategory1Id() {
        return category1Id;
    }

    /**
     * 设置一级类目
     *
     * @param category1Id 一级类目
     */
    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    /**
     * 获取二级类目
     *
     * @return category2_id - 二级类目
     */
    public Long getCategory2Id() {
        return category2Id;
    }

    /**
     * 设置二级类目
     *
     * @param category2Id 二级类目
     */
    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    /**
     * 获取三级类目
     *
     * @return category3_id - 三级类目
     */
    public Long getCategory3Id() {
        return category3Id;
    }

    /**
     * 设置三级类目
     *
     * @param category3Id 三级类目
     */
    public void setCategory3Id(Long category3Id) {
        this.category3Id = category3Id;
    }

    /**
     * 获取小图
     *
     * @return small_pic - 小图
     */
    public String getSmallPic() {
        return smallPic;
    }

    /**
     * 设置小图
     *
     * @param smallPic 小图
     */
    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    /**
     * 获取商城价
     *
     * @return price - 商城价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商城价
     *
     * @param price 商城价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取分类模板ID
     *
     * @return type_template_id - 分类模板ID
     */
    public Long getTypeTemplateId() {
        return typeTemplateId;
    }

    /**
     * 设置分类模板ID
     *
     * @param typeTemplateId 分类模板ID
     */
    public void setTypeTemplateId(Long typeTemplateId) {
        this.typeTemplateId = typeTemplateId;
    }

    /**
     * 获取是否启用规格
     *
     * @return is_enable_spec - 是否启用规格
     */
    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    /**
     * 设置是否启用规格
     *
     * @param isEnableSpec 是否启用规格
     */
    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    /**
     * 获取是否删除
     *
     * @return is_delete - 是否删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", defaultItemId=").append(defaultItemId);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", isMarketable=").append(isMarketable);
        sb.append(", brandId=").append(brandId);
        sb.append(", caption=").append(caption);
        sb.append(", category1Id=").append(category1Id);
        sb.append(", category2Id=").append(category2Id);
        sb.append(", category3Id=").append(category3Id);
        sb.append(", smallPic=").append(smallPic);
        sb.append(", price=").append(price);
        sb.append(", typeTemplateId=").append(typeTemplateId);
        sb.append(", isEnableSpec=").append(isEnableSpec);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", nickName=").append(nickName);
        sb.append(", brandName=").append(brandName);
        sb.append(", category1Name=").append(category1Name);
        sb.append(", category2Name=").append(category2Name);
        sb.append(", category3Name=").append(category3Name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}