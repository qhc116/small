package com.xjtuse.mall.result;

import java.util.List;

public class MutlResultVo<T> {
    private List<T> item;
    private String errmsg;
    private Integer errno;

    @Override
    public String toString() {
        return "ResultVo{" +
                "item=" + item +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }

    public List getItem() {
        return item;
    }

    public void setItem(List item) {
        this.item = item;
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
