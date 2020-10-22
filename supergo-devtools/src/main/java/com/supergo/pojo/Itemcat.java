package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

@ApiModel(value="com.supergo.pojo.Itemcat")
@Table(name = "tb_item_cat")
public class Itemcat implements Serializable {
    /**
     * 类目ID
     */
    @Id
    @ApiModelProperty(value="id类目ID")
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @Column(name = "parent_id")
    @ApiModelProperty(value="parentId父类目ID=0时，代表的是一级的类目")
    private Long parentId;

    /**
     * 类目名称
     */
    @ApiModelProperty(value="name类目名称")
    private String name;

    /**
     * 类型id
     */
    @Column(name = "type_id")
    @ApiModelProperty(value="typeId类型id")
    private Long typeId;

    private static final long serialVersionUID = 1L;

    public Itemcat(Long id, Long parentId, String name, Long typeId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.typeId = typeId;
    }

    public Itemcat() {
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
     * 获取父类目ID=0时，代表的是一级的类目
     *
     * @return parent_id - 父类目ID=0时，代表的是一级的类目
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父类目ID=0时，代表的是一级的类目
     *
     * @param parentId 父类目ID=0时，代表的是一级的类目
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取类目名称
     *
     * @return name - 类目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类目名称
     *
     * @param name 类目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型id
     *
     * @return type_id - 类型id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置类型id
     *
     * @param typeId 类型id
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}