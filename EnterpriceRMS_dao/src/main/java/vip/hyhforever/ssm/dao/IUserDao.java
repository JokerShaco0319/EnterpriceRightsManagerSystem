package vip.hyhforever.ssm.dao;

import org.apache.ibatis.annotations.*;
import vip.hyhforever.ssm.domain.Role;
import vip.hyhforever.ssm.domain.UserInfo;

import java.util.List;

public interface IUserDao {

    @Select("select * from user where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "vip.hyhforever.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    @Select("select * from user")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into user(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 功能描述：根据Id查询用户的所有信息并使用UserInfo类进行封装
     * @param userId 需要查询的用户Id
     * @return UserInfo
     **/
    @Select("select * from user where id = #{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",javaType = java.util.List.class, many = @Many(select = "vip.hyhforever.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String userId);
}
