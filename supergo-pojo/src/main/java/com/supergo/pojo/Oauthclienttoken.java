package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value="com.supergo.pojo.Oauthclienttoken")
@Table(name = "oauth_client_token")
public class Oauthclienttoken implements Serializable {
    @Id
    @Column(name = "authentication_id")
    @ApiModelProperty(value="authenticationId")
    private String authenticationId;

    @Column(name = "token_id")
    @ApiModelProperty(value="tokenId")
    private String tokenId;

    @Column(name = "user_name")
    @ApiModelProperty(value="userName")
    private String userName;

    @Column(name = "client_id")
    @ApiModelProperty(value="clientId")
    private String clientId;

    @ApiModelProperty(value="token")
    private byte[] token;

    private static final long serialVersionUID = 1L;

    public Oauthclienttoken(String authenticationId, String tokenId, String userName, String clientId) {
        this.authenticationId = authenticationId;
        this.tokenId = tokenId;
        this.userName = userName;
        this.clientId = clientId;
    }

    public Oauthclienttoken(String authenticationId, String tokenId, String userName, String clientId, byte[] token) {
        this.authenticationId = authenticationId;
        this.tokenId = tokenId;
        this.userName = userName;
        this.clientId = clientId;
        this.token = token;
    }

    public Oauthclienttoken() {
        super();
    }

    /**
     * @return authentication_id
     */
    public String getAuthenticationId() {
        return authenticationId;
    }

    /**
     * @param authenticationId
     */
    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    /**
     * @return token_id
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * @param tokenId
     */
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return client_id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return token
     */
    public byte[] getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(byte[] token) {
        this.token = token;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authenticationId=").append(authenticationId);
        sb.append(", tokenId=").append(tokenId);
        sb.append(", userName=").append(userName);
        sb.append(", clientId=").append(clientId);
        sb.append(", token=").append(token);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}