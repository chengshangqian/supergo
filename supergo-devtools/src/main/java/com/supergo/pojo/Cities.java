package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

@ApiModel(value="com.supergo.pojo.Cities")
@Table(name = "tb_cities")
public class Cities implements Serializable {
    /**
     * 唯一ID
     */
    @Id
    @ApiModelProperty(value="id唯一ID")
    private Integer id;

    /**
     * 城市ID
     */
    @ApiModelProperty(value="cityid城市ID")
    private String cityid;

    /**
     * 城市名称
     */
    @ApiModelProperty(value="city城市名称")
    private String city;

    /**
     * 省份ID
     */
    @ApiModelProperty(value="provinceid省份ID")
    private String provinceid;

    private static final long serialVersionUID = 1L;

    public Cities(Integer id, String cityid, String city, String provinceid) {
        this.id = id;
        this.cityid = cityid;
        this.city = city;
        this.provinceid = provinceid;
    }

    public Cities() {
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
     * 获取城市ID
     *
     * @return cityid - 城市ID
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * 设置城市ID
     *
     * @param cityid 城市ID
     */
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    /**
     * 获取城市名称
     *
     * @return city - 城市名称
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市名称
     *
     * @param city 城市名称
     */
    public void setCity(String city) {
        this.city = city;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cityid=").append(cityid);
        sb.append(", city=").append(city);
        sb.append(", provinceid=").append(provinceid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}