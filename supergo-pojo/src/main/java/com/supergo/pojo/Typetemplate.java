package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value="com.supergo.pojo.Typetemplate")
@Table(name = "tb_type_template")
public class Typetemplate implements Serializable {
    @Id
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 模板名称
     */
    @ApiModelProperty(value="name模板名称")
    private String name;

    /**
     * 关联规格
     */
    @Column(name = "spec_ids")
    @ApiModelProperty(value="specIds关联规格")
    private String specIds;

    /**
     * 关联品牌
     */
    @Column(name = "brand_ids")
    @ApiModelProperty(value="brandIds关联品牌")
    private String brandIds;

    /**
     * 自定义属性
     */
    @Column(name = "custom_attribute_items")
    @ApiModelProperty(value="customAttributeItems自定义属性")
    private String customAttributeItems;

    private static final long serialVersionUID = 1L;

    public Typetemplate(Long id, String name, String specIds, String brandIds, String customAttributeItems) {
        this.id = id;
        this.name = name;
        this.specIds = specIds;
        this.brandIds = brandIds;
        this.customAttributeItems = customAttributeItems;
    }

    public Typetemplate() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取模板名称
     *
     * @return name - 模板名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置模板名称
     *
     * @param name 模板名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取关联规格
     *
     * @return spec_ids - 关联规格
     */
    public String getSpecIds() {
        return specIds;
    }

    /**
     * 设置关联规格
     *
     * @param specIds 关联规格
     */
    public void setSpecIds(String specIds) {
        this.specIds = specIds;
    }

    /**
     * 获取关联品牌
     *
     * @return brand_ids - 关联品牌
     */
    public String getBrandIds() {
        return brandIds;
    }

    /**
     * 设置关联品牌
     *
     * @param brandIds 关联品牌
     */
    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds;
    }

    /**
     * 获取自定义属性
     *
     * @return custom_attribute_items - 自定义属性
     */
    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    /**
     * 设置自定义属性
     *
     * @param customAttributeItems 自定义属性
     */
    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", specIds=").append(specIds);
        sb.append(", brandIds=").append(brandIds);
        sb.append(", customAttributeItems=").append(customAttributeItems);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}