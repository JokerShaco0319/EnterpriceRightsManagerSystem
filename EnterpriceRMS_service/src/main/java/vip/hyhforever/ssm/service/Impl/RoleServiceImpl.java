package vip.hyhforever.ssm.service.Impl;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/1 , 19:22
 * 功能描述：角色相关业务的服务层
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.hyhforever.ssm.dao.IRoleDao;
import vip.hyhforever.ssm.domain.Permission;
import vip.hyhforever.ssm.domain.Role;
import vip.hyhforever.ssm.service.IRoleService;

import java.util.List;

@Service()
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao dao;

    /**
     * 功能描述：查询所有的角色信息
     * @return role的List集合
     **/
    @Override
    public List<Role> findAll() throws Exception {
        return dao.findAll();
    }

    /**
     * 功能描述：存储一个新的角色
     * @param role 需要保存的role对象
     **/
    @Override
    public void save(Role role) throws Exception {
        dao.save(role);
    }

    /**
     * 功能描述：根据Id查询一个角色的全部信息
     * @param roleId 需要查询的角色Id
     * @return Role 查询到的Role
     **/
    @Override
    public Role findById(String roleId) throws Exception {
        return dao.findById(roleId);
    }

    /**
     * 功能描述：根据角色Id查询当前角色还可以添加的角色信息
     * @param roleId 角色Id
     * @return Permission集合
     **/
    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return dao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String id : ids) {
            dao.addPermissionToRole(roleId,id);
        }
    }
}
