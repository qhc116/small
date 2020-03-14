package com.xjtuse.mall.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.xjtuse.mall.bean.system.Storage;
import com.xjtuse.mall.result.BaseResultVo;
import com.xjtuse.mall.result.MapResultVo;
import com.xjtuse.mall.result.ListResultVo;
import com.xjtuse.mall.result.ResultVo;
import com.xjtuse.mall.result.TResultVo;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 失了秩
 * @date 2020/3/11 18:40
 * @description errno：  0成功 1失败
 */
public class ResultUtil {
    public static BaseResultVo baseResultVoOk(Storage o) {
        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setData(o);
        baseResultVo.setErrmsg("成功");
        baseResultVo.setErrno(0);
        return baseResultVo;
    }

    public static MapResultVo ok(Object data, Integer total) {
        MapResultVo mapResultVo = new MapResultVo();
        HashMap map = new HashMap<>();
        map.put("items",data);
        map.put("total",total);
        mapResultVo.setData(map);
        mapResultVo.setErrmsg("成功");
        mapResultVo.setErrno(0);
        return mapResultVo;
    }

    public static ListResultVo categoryOk(List data) {
        ListResultVo resultVo = new ListResultVo();
        resultVo.setData(data);
        resultVo.setErrmsg("成功");
        resultVo.setErrno(0);
        return resultVo;
    }

    public static MapResultVo catAndBrandOk(Map map) {
        MapResultVo mapResultVo = new MapResultVo();
        mapResultVo.setData(map);
        mapResultVo.setErrmsg("成功");
        mapResultVo.setErrno(0);
        return mapResultVo;
    }

    public static ResultVo fail(ResultVo resultVo, @Nullable Integer errno, @Nullable String errmsg) {
        if (errno == null || errmsg == null) {
            resultVo.setErrmsg("失败，请联系管理员");
            resultVo.setErrno(0);
        } else {
            resultVo.setErrmsg(errmsg);
            resultVo.setErrno(errno);
        }
        return resultVo;
    }

    public static TResultVo genSuccessResult(Object data){
        TResultVo resultVo = new TResultVo();
        resultVo.setData(data);
        resultVo.setErrmsg("成功");
        resultVo.setErrno(0);
        return resultVo;
    }

    public static TResultVo genSuccessResult(){
        TResultVo resultVo = new TResultVo();
        resultVo.setErrmsg("成功");
        resultVo.setErrno(0);
        return resultVo;
    }

}
