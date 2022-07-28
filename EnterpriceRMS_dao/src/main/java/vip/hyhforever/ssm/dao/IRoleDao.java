package vip.hyhforever.ssm.dao;

import vip.hyhforever.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    /**
     * 功能描述：根据用户的id查询中间表，获取该用户的所有角色类型
     * @param userId 用户表的id字段
     * @return List-Role 该用户对应的所有角色
     **/
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    List<Role> findRoleByUserId(String userId) throws Exception;
}
