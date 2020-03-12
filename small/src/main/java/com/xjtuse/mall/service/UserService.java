package com.xjtuse.mall.service;

import com.xjtuse.mall.bean.User;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.utils.PageUtil;

public interface UserService {
    ResultVo queryById();

    ResultVo queryAll(PageUtil pageUtil, User user);
}
