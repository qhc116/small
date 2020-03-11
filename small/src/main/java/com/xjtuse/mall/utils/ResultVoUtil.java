package com.xjtuse.mall.utils;

import com.xjtuse.mall.result.ResultVo;
import org.springframework.lang.Nullable;

/**
 * @author 失了秩
 * @date 2020/3/11 18:40
 * @description errno：  0成功 1失败
 */
public class ResultVoUtil {
    public static ResultVo ok(ResultVo resultVo) {
        resultVo.setErrmsg("成功");
        resultVo.setErrno(0);
        return resultVo;
    }

    public static ResultVo fail(ResultVo resultVo, @Nullable Integer errno,@Nullable String errmsg) {
        if (errno == null || errmsg == null) {
            resultVo.setErrmsg("失败，请联系管理员");
            resultVo.setErrno(0);
        } else {
            resultVo.setErrmsg(errmsg);
            resultVo.setErrno(errno);
        }
        return resultVo;
    }
}
