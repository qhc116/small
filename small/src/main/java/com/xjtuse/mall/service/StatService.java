package com.xjtuse.mall.service;

import com.xjtuse.mall.result.TResultVo;
import org.omg.CORBA.TRANSACTION_MODE;

public interface StatService {

    TResultVo queryUserStat();

    TResultVo queryOrderStat();

    TResultVo queryGoodsStat();

}
