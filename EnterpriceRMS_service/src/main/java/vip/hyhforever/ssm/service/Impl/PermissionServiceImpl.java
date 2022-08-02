package vip.hyhforever.ssm.service.Impl;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/2 , 10:44
 * 功能描述：
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.hyhforever.ssm.dao.IPermissionDao;
import vip.hyhforever.ssm.domain.Permission;
import vip.hyhforever.ssm.service.IPermissionService;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
