package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

@ApiModel(value="com.supergo.pojo.Provinces")
@Table(name = "tb_provinces")
public class Provinces implements Serializable {
    /**
     * 唯一ID
     */
    @Id
    @ApiModelProperty(value="id唯一ID")
    private Integer id;

    /**
     * 省份ID
     */
    @ApiModelProperty(value="provinceid省份ID")
    private String provinceid;

    /**
     * 省份名称
     */
    @ApiModelProperty(value="province省份名称")
    private String province;

    private static final long serialVersionUID = 1L;

    public Provinces(Integer id, String provinceid, String province) {
        this.id = id;
        this.provinceid = provinceid;
        this.province = province;
    }

    public Provinces() {
        super();
    }

    /**
     * 获取唯一ID
     *
     * @return id - 唯一ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置唯一ID
     *
     * @param id 唯一ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取省份ID
     *
     * @return provinceid - 省份ID
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * 设置省份ID
     *
     * @param provinceid 省份ID
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    /**
     * 获取省份名称
     *
     * @return province - 省份名称
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份名称
     *
     * @param province 省份名称
     */
    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", provinceid=").append(provinceid);
        sb.append(", province=").append(province);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}