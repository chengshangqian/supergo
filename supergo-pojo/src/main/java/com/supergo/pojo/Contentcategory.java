package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value="com.supergo.pojo.Contentcategory")
@Table(name = "tb_content_category")
public class Contentcategory implements Serializable {
    /**
     * 类目ID
     */
    @Id
    @ApiModelProperty(value="id类目ID")
    private Long id;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="name分类名称")
    private String name;

    private static final long serialVersionUID = 1L;

    public Contentcategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Contentcategory() {
        super();
    }

    /**
     * 获取类目ID
     *
     * @return id - 类目ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置类目ID
     *
     * @param id 类目ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}