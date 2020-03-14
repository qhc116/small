package com.xjtuse.mall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import com.xjtuse.mall.bean.system.Storage;
import com.xjtuse.mall.result.BaseResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.SystemService;
import com.xjtuse.mall.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
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

    @RequestMapping("/storage/fetch/{path}")
    public void storageFetch(@PathVariable("path") String path, HttpServletResponse response) {
        try( ServletOutputStream outputStream = response.getOutputStream();
             FileInputStream inputStream = new FileInputStream(new File("small/src/main/resources/static/" + path))) {
            byte[] bytes = new byte[1024];
            int lenth;
            while ((lenth = inputStream.read(bytes)) != 0) {
                outputStream.write(bytes,0,lenth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
