package vip.hyhforever.ssm.dao;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/1 , 18:32
 * 功能描述：权限类的相关操作
 * */

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import vip.hyhforever.ssm.domain.Permission;

import java.util.List;

public interface IPermissionDao {

    /**
     * 功能描述：根据用户id查询该用户的所有权限信息
     * @param userId 用户唯一id值
     * @return List 返回一个Permission类的集合
     **/
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermissionById(String userId) throws Exception;


    /**
     * 功能描述：查询所有的资源权限
     * @return 返回权限信息的集合
     **/
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName, url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
