package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.User;
import com.xjtuse.mall.mapper.UserMapper;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.UserService;
import com.xjtuse.mall.utils.MutiResultVoUtil;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResultVo queryAll(PageUtil pageUtil, User user) {
        pageUtil.initStart();
        List<User> items = mapper.queryAll(pageUtil, user);
        Integer count = mapper.queryCount();
        return MutiResultVoUtil.ok(items, count);
    }

    @Override
    public ResultVo queryById() {
        List<User> item  = mapper.queryById(1);
        return MutiResultVoUtil.ok(item,22);
    }


}
