package com.supergo.authorization.pojo;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Data
public class User implements UserDetails {
    // 序列化id
    private static final long serialVersionUID = -1000005L;

    // 用户id
    private Long id;

    // 角色列表
    private Collection<Role> authorities;

    // 账号
    private String username;
    // 密码
    private String password;
    // 账号未过期
    private boolean accountNonExpired = true;
    // 账号未锁定
    private boolean accountNonLocked = true;
    // 凭据未失效
    private boolean credentialsNonExpired = true;
    // 账号已启用
    private boolean enabled = true;

    /**
     * 用户角色列表
     *
     * @return
     */
    @Override
    public Collection<Role> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
