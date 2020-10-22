package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value="com.supergo.pojo.Oauthcode")
@Table(name = "oauth_code")
public class Oauthcode implements Serializable {
    @ApiModelProperty(value="code")
    private String code;

    @ApiModelProperty(value="authentication")
    private byte[] authentication;

    private static final long serialVersionUID = 1L;

    public Oauthcode(String code) {
        this.code = code;
    }

    public Oauthcode(String code, byte[] authentication) {
        this.code = code;
        this.authentication = authentication;
    }

    public Oauthcode() {
        super();
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return authentication
     */
    public byte[] getAuthentication() {
        return authentication;
    }

    /**
     * @param authentication
     */
    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", authentication=").append(authentication);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}