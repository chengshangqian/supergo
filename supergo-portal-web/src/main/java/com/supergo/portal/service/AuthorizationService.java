package com.supergo.portal.service;

import com.supergo.common.authorization.AccessToken;

public interface AuthorizationService {
    AccessToken authorize(String username, String password);
}
