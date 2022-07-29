package vip.hyhforever.ssm.service;

import org.springframework.security.core.userdetails.UserDetailsService;
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
}
