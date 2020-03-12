package com.xjtuse.mall.result;

import java.util.List;
import java.util.Map;

public class ResultVo {
    private Map data;
    private String errmsg;
    private Integer errno;

    @Override
    public String toString() {
        return "ResultVo{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }

    public void setData(Map data) {
        this.data = data;
    }

    public Map getData() {
        return data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }
}
