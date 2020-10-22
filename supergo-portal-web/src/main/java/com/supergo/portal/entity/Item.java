package com.supergo.portal.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

// SpringBoot启动时会自动创建索引和映射，但要注意如果已经存在相同的index，必须先删除
@Document(indexName = "item") // ES文档索引，必须小写
public class Item implements Serializable {

    @Id
    @Field(name = "item_id",type = FieldType.Long)
    private Long id;

    @Field(name = "item_name", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String itemName;

    @Field(name = "item_desc", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String itemDesc;

    @Field(name = "item_price", type = FieldType.Scaled_Float)
    private BigDecimal itemPrice;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
