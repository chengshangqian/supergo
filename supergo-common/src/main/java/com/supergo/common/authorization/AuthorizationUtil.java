package com.supergo.common.authorization;

public class AuthorizationUtil {
    public static final String TOKEN_TYPE_BEARER = "Bearer";
    public static final String TOKEN_TYPE_BASIC = "Basic";
    public static final String AUTHORIZATION_FORMAT = "%s %s";

    public static String bearerAuthorization(String accessToken){
        return authorization(accessToken,TOKEN_TYPE_BEARER);
    }

    public static String basicAuthorization(String accessToken){
        return authorization(accessToken,TOKEN_TYPE_BASIC);
    }

    public static String authorization(String token,String tokenType){
        return String.format(AUTHORIZATION_FORMAT,tokenType,token);
    }
}
