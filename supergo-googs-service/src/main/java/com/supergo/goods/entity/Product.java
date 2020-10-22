package com.supergo.goods.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

// SpringBoot启动时会自动创建索引和映射，但要注意如果已经存在相同的index，必须先删除
@Document(indexName = "product") // ES文档索引，必须小写
public class Product implements Serializable {

    @Id
    @Field(name = "product_id",type = FieldType.Long)
    private Long id;

    @Field(name = "product_name", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String productName;

    @Field(name = "product_desc", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String productDesc;

    @Field(name = "product_price", type = FieldType.Scaled_Float)
    private BigDecimal productPrice;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
