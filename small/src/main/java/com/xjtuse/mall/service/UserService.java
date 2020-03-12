package com.xjtuse.mall.service;

import com.xjtuse.mall.bean.user.*;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.utils.PageUtil;

public interface UserService {
    ResultVo queryAllUser(PageUtil pageUtil, User user);

    ResultVo queryAddress(PageUtil pageUtil, Address address);

    ResultVo queryCollect(PageUtil pageUtil, Collect collect);

    ResultVo queryFootprint(PageUtil pageUtil, Footprint footprint);

    ResultVo querySearchHistory(PageUtil pageUtil, SearchHistory searchHistory);

    ResultVo queryFeedback(PageUtil pageUtil, Feedback feedback);
}
