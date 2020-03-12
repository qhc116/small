package com.xjtuse.mall.controller;

import com.xjtuse.mall.bean.user.*;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.UserService;
import com.xjtuse.mall.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/list")
    public ResultVo userList(PageUtil pageUtil, User user) {
        return userService.queryAllUser(pageUtil, user);
    }

    @RequestMapping("/address/list")
    public ResultVo addressList(PageUtil pageUtil, Address address) {
        return userService.queryAddress(pageUtil, address);
    }

    @RequestMapping("/collect/list")
    public ResultVo collectionList(PageUtil pageUtil, Collect collect) {
        return userService.queryCollect(pageUtil, collect);
    }

    @RequestMapping("/footprint/list")
    public ResultVo footprintList(PageUtil pageUtil, Footprint footprint) {
        return userService.queryFootprint(pageUtil, footprint);
    }

    @RequestMapping("/history/list")
    public ResultVo historyList(PageUtil pageUtil, SearchHistory searchHistory) {
        return userService.querySearchHistory(pageUtil, searchHistory);
    }

    @RequestMapping("/feedback/list")
    public ResultVo feedbackList(PageUtil pageUtil, Feedback feedback) {
        return userService.queryFeedback(pageUtil, feedback);
    }

}
