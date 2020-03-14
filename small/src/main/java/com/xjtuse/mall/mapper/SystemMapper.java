package com.xjtuse.mall.mapper;

import com.xjtuse.mall.bean.system.Storage;
import org.apache.ibatis.annotations.Param;
import sun.security.krb5.internal.crypto.ArcFourHmacEType;

/**
 * @author 失了秩
 * @date 2020/3/14 16:18
 * @description
 */
public interface SystemMapper {
    void storageCreate(@Param("storage") Storage storage);
}
