package vip.hyhforever.ssm.service;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/3 , 18:16
 * 功能描述：日志相关操作
 * */

import vip.hyhforever.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll();
}
