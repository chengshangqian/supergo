package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

@ApiModel(value="com.supergo.pojo.Oauthclientdetails")
@Table(name = "oauth_client_details")
public class Oauthclientdetails implements Serializable {
    @Id
    @Column(name = "client_id")
    @ApiModelProperty(value="clientId")
    private String clientId;

    @Column(name = "resource_ids")
    @ApiModelProperty(value="resourceIds")
    private String resourceIds;

    @Column(name = "client_secret")
    @ApiModelProperty(value="clientSecret")
    private String clientSecret;

    @ApiModelProperty(value="scope")
    private String scope;

    @Column(name = "authorized_grant_types")
    @ApiModelProperty(value="authorizedGrantTypes")
    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri")
    @ApiModelProperty(value="webServerRedirectUri")
    private String webServerRedirectUri;

    @ApiModelProperty(value="authorities")
    private String authorities;

    @Column(name = "access_token_validity")
    @ApiModelProperty(value="accessTokenValidity")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity")
    @ApiModelProperty(value="refreshTokenValidity")
    private Integer refreshTokenValidity;

    @Column(name = "additional_information")
    @ApiModelProperty(value="additionalInformation")
    private String additionalInformation;

    @ApiModelProperty(value="autoapprove")
    private String autoapprove;

    private static final long serialVersionUID = 1L;

    public Oauthclientdetails(String clientId, String resourceIds, String clientSecret, String scope, String authorizedGrantTypes, String webServerRedirectUri, String authorities, Integer accessTokenValidity, Integer refreshTokenValidity, String additionalInformation, String autoapprove) {
        this.clientId = clientId;
        this.resourceIds = resourceIds;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.webServerRedirectUri = webServerRedirectUri;
        this.authorities = authorities;
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
        this.additionalInformation = additionalInformation;
        this.autoapprove = autoapprove;
    }

    public Oauthclientdetails() {
        super();
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
     * @return resource_ids
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * @param resourceIds
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    /**
     * @return client_secret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * @param clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * @return scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return authorized_grant_types
     */
    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * @param authorizedGrantTypes
     */
    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    /**
     * @return web_server_redirect_uri
     */
    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * @param webServerRedirectUri
     */
    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    /**
     * @return authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    /**
     * @return access_token_validity
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * @param accessTokenValidity
     */
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    /**
     * @return refresh_token_validity
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * @param refreshTokenValidity
     */
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    /**
     * @return additional_information
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * @return autoapprove
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * @param autoapprove
     */
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clientId=").append(clientId);
        sb.append(", resourceIds=").append(resourceIds);
        sb.append(", clientSecret=").append(clientSecret);
        sb.append(", scope=").append(scope);
        sb.append(", authorizedGrantTypes=").append(authorizedGrantTypes);
        sb.append(", webServerRedirectUri=").append(webServerRedirectUri);
        sb.append(", authorities=").append(authorities);
        sb.append(", accessTokenValidity=").append(accessTokenValidity);
        sb.append(", refreshTokenValidity=").append(refreshTokenValidity);
        sb.append(", additionalInformation=").append(additionalInformation);
        sb.append(", autoapprove=").append(autoapprove);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}