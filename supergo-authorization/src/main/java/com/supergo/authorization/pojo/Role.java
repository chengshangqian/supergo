package com.supergo.authorization.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * 角色：资源分类，实现授权接口
 */
@Data
public class Role implements GrantedAuthority {
    // 序列化id
    private static final long serialVersionUID = -1000004L;

    // 角色id
    private String id;

    // 角色名称
    private String roleName;

    // 角色编码
    private String roleCode;

    /**
     * 使用角色编码作为权限标识
     *
     * @return
     */
    @Override
    public String getAuthority() {
        return roleCode;
    }
}
