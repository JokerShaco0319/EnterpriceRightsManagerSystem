package vip.hyhforever.ssm.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vip.hyhforever.ssm.domain.Role;
import vip.hyhforever.ssm.domain.UserInfo;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 功能描述： 查询所有的用户信息
     * @return List 返回所有用户信息的集合
     **/
    List<UserInfo> findAll() throws Exception;

    /**
     * 功能描述：在数据库中插入一条用户信息
     **/
    void save(UserInfo userInfo) throws Exception;


    /**
     * 功能描述：以UserInfo的形式返回查询到的所有有关Id的用户信息
     * @param userId 需要查询的用户Id
     * @return UserInfo
     **/
    UserInfo findById(String userId);

    /**
     * 功能描述：根据ID查询当前用户可以添加的所有角色
     * @param userid 需要查询的用户id
     * @return 用户可以添加的其他角色的集合
     **/
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * 功能描述：对当前用户添加至少一个角色
     * @param userId 当前用户id
     * @param ids 多个角色的唯一ID
     **/
    void addRoleToUser(String userId, String[] ids);
}
