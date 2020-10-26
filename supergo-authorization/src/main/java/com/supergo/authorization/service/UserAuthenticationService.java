package com.supergo.authorization.service;

import com.supergo.authorization.dao.UserAuthenticationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户认证服务
 */
@Service
public class UserAuthenticationService implements UserDetailsService {
    @Autowired
    private UserAuthenticationDao userAuthenticationDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthenticationDao.getByUsername(username);
    }
}
