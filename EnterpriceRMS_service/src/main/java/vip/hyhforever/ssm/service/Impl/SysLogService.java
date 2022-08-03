package vip.hyhforever.ssm.service.Impl;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/3 , 18:17
 * 功能描述：ISysLogService的实现类，完成日志的相关操作
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.hyhforever.ssm.dao.ISysLogDao;
import vip.hyhforever.ssm.domain.SysLog;
import vip.hyhforever.ssm.service.ISysLogService;

import java.util.List;

@Service
@Transactional
public class SysLogService implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
