package com.xjtuse.mall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjtuse.mall.bean.system.Storage;
import com.xjtuse.mall.result.BaseResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.SystemService;
import com.xjtuse.mall.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;

/**
 * @author 失了秩
 * @date 2020/3/14 14:27
 * @description
 */
@RestController
public class SystemController {

    @Autowired
    SystemService service;

    @RequestMapping("/storage/create")
    public ResultVo storageCreate(MultipartFile file) throws JsonProcessingException {
        return service.storageCreate(file);
    }
}
