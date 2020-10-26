package com.supergo.authorization.dao;

import com.supergo.authorization.pojo.Role;
import com.supergo.authorization.pojo.User;
import lombok.experimental.var;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserAuthenticationDao {
    @Select("SELECT id,username,password FROM tb_user WHERE username = #{username}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="password",property="password"),
            @Result(column="id",property="authorities",
                    many=@Many(
                            select="selectRoles"
                    )
            )
    })
    User getByUsername(String username);

    @Select("SELECT r.id,r.role_name,r.role_code FROM tb_role r,tb_user_role ur WHERE r.id = ur.role_id AND ur.user_id = #{id}")
    List<Role> selectRoles(Integer id);
}
