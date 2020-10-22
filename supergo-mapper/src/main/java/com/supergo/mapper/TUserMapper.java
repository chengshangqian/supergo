package com.supergo.mapper;

import com.supergo.pojo.TUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TUserMapper extends Mapper<TUser> {
    // 自定方法
    @Select("SELECT count(*) FROM user")
    int totalCount();

    // 自定方法
    int getOneUser(Integer id);
}