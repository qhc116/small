package com.xjtuse.mall.controller;

import com.xjtuse.mall.bean.system.Admin;
import com.xjtuse.mall.bean.system.Role;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.service.SystemService;
import com.xjtuse.mall.utils.FileUploadUtil;
import com.xjtuse.mall.utils.PageUtil;
import com.xjtuse.mall.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResultVo storageCreate(MultipartFile file) {
        return service.storageCreate(file);
    }

    @RequestMapping("/storage/fetch/{path}")
    public void storageFetch(@PathVariable("path") String path, HttpServletResponse response) {

        try( ServletOutputStream outputStream = response.getOutputStream();
             FileInputStream inputStream = new FileInputStream(new File("small/src/main/resources/static/" + path));
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            int available = bufferedInputStream.available();
            System.out.println(available);
            byte[] bytes = new byte[available];
            bufferedInputStream.read(bytes);
            outputStream.write(bytes);


            //            byte[] bytes = new byte[1024];
//            int lenth;
//            while ((lenth = inputStream.read(bytes)) != 0) {
//                outputStream.write(bytes,0,lenth);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/admin/list")
    public ResultVo adminList(PageUtil pageUtil, String username) {
        return service.adminList(pageUtil, username);
    }
    @RequestMapping("/role/options")
    public ResultVo roleOptions() {
        return service.roleOptions();
    }

    @RequestMapping("/admin/update")
    public ResultVo adminUpdate(@RequestBody Admin admin) {
        return service.adminUpdate(admin);
    }

    @RequestMapping("/role/list")
    public ResultVo adminRole(PageUtil pageUtil, Role role) {
        return service.adminRole(pageUtil, role);
    }

    @RequestMapping("/role/update")
    public ResultVo roleUpdate(@RequestBody Role role) {
        return service.roleUpdate(role);
    }

    @RequestMapping("/role/delete")
    public ResultVo roleDelete(@RequestBody Role role) {
        return service.roleDelete(role);
    }

}
