package com.wallet.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wallet.entiy.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author Pom
 */
public interface LogDao extends BaseMapper<Log> {
    @Insert("insert into log values(null,#{log.username},#{log.creattime},#{log.type},#{log.amount},#{log.yue},#{log.orderId},#{log.transactionId},#{log.coumsername})")
    void add(@Param("log") Log log);

}
