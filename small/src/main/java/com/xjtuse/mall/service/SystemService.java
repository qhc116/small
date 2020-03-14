package com.xjtuse.mall.service;

import com.xjtuse.mall.bean.system.Storage;
import com.xjtuse.mall.result.BaseResultVo;
import com.xjtuse.mall.result.ResultVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 失了秩
 * @date 2020/3/14 16:14
 * @description
 */
public interface SystemService {
    ResultVo storageCreate(MultipartFile file);
}
