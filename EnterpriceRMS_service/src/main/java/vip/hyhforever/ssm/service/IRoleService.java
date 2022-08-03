package vip.hyhforever.ssm.service;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/1 , 19:21
 * 功能描述：角色操作相关的Service层
 * */

import vip.hyhforever.ssm.domain.Permission;
import vip.hyhforever.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermission(String roleId);

    void addPermissionToRole(String roleId, String[] ids);
}
