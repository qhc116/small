package com.xjtuse.mall.utils;

import com.xjtuse.mall.bean.system.Storage;
import org.springframework.web.multipart.MultipartFile;
import sun.security.provider.MD5;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 失了秩
 * @date 2020/3/14 15:11
 * @description
 */
public class FileUploadUtil {

    public static Storage init(MultipartFile file) {
        transfer(file);
        String md5 = getFileMD5(file);
        Storage storage = new Storage();
        storage.setName(file.getOriginalFilename());
        storage.setDeleted(false);
        storage.setUrl("http://122.51.199.160:8080/admin/storage/fetch/" + md5);
        storage.setSize((int) file.getSize());
        storage.setType(file.getContentType());
        storage.setKey(md5);
        return storage;
    }

    public static void transfer(MultipartFile file) {
        try {
            File path =
                    new File("small/src/main/resources/static/" + file.getOriginalFilename());
            if (!path.getParentFile().exists()) {
                path.getParentFile().mkdirs();
            }

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
            bufferedOutputStream.write(file.getBytes());
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getFileMD5(MultipartFile file) {
        MessageDigest digest = null;
        String md5 = null;
        try {
            digest = MessageDigest.getInstance("md5");
            md5 = digest.digest(file.getBytes()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return md5;
    }
}
