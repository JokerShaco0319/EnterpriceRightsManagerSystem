package vip.hyhforever.ssm.dao;

import org.apache.ibatis.annotations.*;
import vip.hyhforever.ssm.domain.Role;

import java.util.List;

public interface IRoleDao {

    /**
     * 功能描述：根据用户的id查询中间表，获取该用户的所有角色类型
     * @param userId 用户表的id字段
     * @return List-Role 该用户对应的所有角色
     **/
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "vip.hyhforever.ssm.dao.IPermissionDao.findPermissionById")),
    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    void save(Role role) throws Exception;
}
