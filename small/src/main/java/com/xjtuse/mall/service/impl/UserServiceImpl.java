package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.User;
import com.xjtuse.mall.mapper.UserMapper;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 失了秩
 * @date 2020/3/11 19:19
 * @description
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public ResultVo queryById() {
        List<User> data  = mapper.queryById(1);
        ResultVo<User> res = new ResultVo<>();
        res.setItem(data);
        return res;
    }
}
