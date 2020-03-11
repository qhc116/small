package com.xjtuse.mall.mapper;

import com.xjtuse.mall.bean.User;

import java.util.List;

public interface UserMapper {
    List<User> queryById(int id);
}
