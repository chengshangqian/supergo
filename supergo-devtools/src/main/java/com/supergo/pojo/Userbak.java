package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

@ApiModel(value="com.supergo.pojo.Userbak")
@Table(name = "tb_user_bak")
public class Userbak implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @ApiModelProperty(value="id主键ID")
    private Integer id;

    /**
     * 密码
     */
    @ApiModelProperty(value="password密码")
    private String password;

    /**
     * 用户名
     */
    @ApiModelProperty(value="username用户名")
    private String username;

    private static final long serialVersionUID = 1L;

    public Userbak(Integer id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public Userbak() {
        super();
    }

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", password=").append(password);
        sb.append(", username=").append(username);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}