package com.supergo.portal.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "search-goods")
public class SearchGoods {

    @Id
    @Field(type = FieldType.Long, store = true)
    private long id;
    @Field(type = FieldType.Text, store = true, analyzer = "ik_max_word")
    private String goods_name;
    @Field(type = FieldType.Keyword, store = true)
    private String seller_id;
    @Field(type = FieldType.Keyword, store = true)
    private String nick_name;
    @Field(type = FieldType.Long, store = true)
    private long brand_id;
    @Field(type = FieldType.Keyword, store = true)
    private String brand_name;
    @Field(type = FieldType.Long, store = true)
    private long category1_id;
    @Field(type = FieldType.Keyword, store = true)
    private String cname1;
    @Field(type = FieldType.Long, store = true)
    private long category2_id;
    @Field(type = FieldType.Keyword, store = true)
    private String cname2;
    @Field(type = FieldType.Long, store = true)
    private long category3_id;
    @Field(type = FieldType.Keyword, store = true)
    private String cname3;
    @Field(type = FieldType.Keyword, store = true, index = false)
    private String small_pic;
    @Field(type = FieldType.Float, store = true)
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(long brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public long getCategory1_id() {
        return category1_id;
    }

    public void setCategory1_id(long category1_id) {
        this.category1_id = category1_id;
    }

    public String getCname1() {
        return cname1;
    }

    public void setCname1(String cname1) {
        this.cname1 = cname1;
    }

    public long getCategory2_id() {
        return category2_id;
    }

    public void setCategory2_id(long category2_id) {
        this.category2_id = category2_id;
    }

    public String getCname2() {
        return cname2;
    }

    public void setCname2(String cname2) {
        this.cname2 = cname2;
    }

    public long getCategory3_id() {
        return category3_id;
    }

    public void setCategory3_id(long category3_id) {
        this.category3_id = category3_id;
    }

    public String getCname3() {
        return cname3;
    }

    public void setCname3(String cname3) {
        this.cname3 = cname3;
    }

    public String getSmall_pic() {
        return small_pic;
    }

    public void setSmall_pic(String small_pic) {
        this.small_pic = small_pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SearchGoods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", brand_id=" + brand_id +
                ", brand_name='" + brand_name + '\'' +
                ", category1_id=" + category1_id +
                ", cname1='" + cname1 + '\'' +
                ", category2_id=" + category2_id +
                ", cname2='" + cname2 + '\'' +
                ", category3_id=" + category3_id +
                ", cname3='" + cname3 + '\'' +
                ", small_pic='" + small_pic + '\'' +
                ", price=" + price +
                '}';
    }
}
