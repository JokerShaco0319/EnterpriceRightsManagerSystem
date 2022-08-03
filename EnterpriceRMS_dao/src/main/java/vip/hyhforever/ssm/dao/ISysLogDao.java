package vip.hyhforever.ssm.dao;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/3 , 18:18
 * 功能描述：日志操作的持久层
 * */

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import vip.hyhforever.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogDao {

    @Insert("insert into log(visitTime, username, ip, url, executionTime, method)" +
            " values(#{visitTime}, #{username}, #{ip}, #{url}, #{executionTime}, #{method})")
    void save(SysLog sysLog) throws Exception;

    @Select("select * from log")
    List<SysLog> findAll();
}
