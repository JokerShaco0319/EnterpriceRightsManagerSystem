package vip.hyhforever.ssm.service.Impl;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/1 , 19:22
 * 功能描述：
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.hyhforever.ssm.dao.IRoleDao;
import vip.hyhforever.ssm.domain.Role;
import vip.hyhforever.ssm.service.IRoleService;

import java.util.List;

@Service()
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao dao;

    @Override
    public List<Role> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        dao.save(role);
    }
}
