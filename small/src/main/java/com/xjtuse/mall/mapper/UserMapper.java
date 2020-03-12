package com.xjtuse.mall.mapper;

import com.xjtuse.mall.bean.User;
import com.xjtuse.mall.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface UserMapper {
    List<User> queryById(int id);
    List<User> queryAll(@Param("pageUtil") PageUtil pageUtil, @Param("user") User user);
    Integer queryCount();
}
