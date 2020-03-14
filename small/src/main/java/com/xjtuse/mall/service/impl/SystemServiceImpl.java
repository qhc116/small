package com.xjtuse.mall.service.impl;

import com.xjtuse.mall.bean.system.Storage;
import com.xjtuse.mall.mapper.SystemMapper;
import com.xjtuse.mall.result.BaseResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.SystemService;
import com.xjtuse.mall.utils.FileUploadUtil;
import com.xjtuse.mall.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 失了秩
 * @date 2020/3/14 16:15
 * @description
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemMapper mapper;

    @Override
    public BaseResultVo storageCreate(MultipartFile file) {
        Storage storage = FileUploadUtil.init(file);
        mapper.storageCreate(storage);
        BaseResultVo resultVo = ResultUtil.baseResultVoOk(storage);
        return resultVo;
    }
}
