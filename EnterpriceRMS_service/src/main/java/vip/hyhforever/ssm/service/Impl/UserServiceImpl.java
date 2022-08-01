package vip.hyhforever.ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.hyhforever.ssm.dao.IUserDao;
import vip.hyhforever.ssm.domain.Role;
import vip.hyhforever.ssm.domain.UserInfo;
import vip.hyhforever.ssm.service.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//注入IOC【userService】,使用于Spring security框架
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 功能描述：根据用户名查询数据库获取用户对应权限，进行security的权限控制
     * @param username 需要进行权限验证的用户名
     * @return UserDetails 返回一个security的权限验证类
     **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            Logger.getGlobal().info("用户查找失败");
            e.printStackTrace();
        }

        //使用Spring security的规范User对象 封装 自定义的User对象
        assert userInfo != null;
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();//security的需要将密码加密后才能正确获取权限控制，如果数据库没有加密，需要调用加密

        return new User(userInfo.getUsername(),//用户名
                userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true,//用户是否可用
                true, true, true,//其他权限控制
                getAuthority(userInfo.getRoles()));//角色信息
    }


    /**
     * 功能描述：根据用户的角色生成对应security权限
     * @param roles 当前用户对应的角色集合
     * @return List 返回一个security权限控制类的集合
     **/
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            Logger.getGlobal().info("角色信息：ROLE_" + role.getRoleName());
        }
        return list;
    }

    /**
     * 功能描述： 查询所有的用户信息
     * @return List 返回所有用户信息的集合
     **/
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    /**
     * 功能描述：向数据库中插入一条信息
     **/
    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));//对密码进行加密处理
        userDao.save(userInfo);
    }

    /**
     * 功能描述：根据Id查询用户的所有相关数据并封装为UserInfo类
     * @param userId 需要查询的用户Id
     * @return UserInfo
     **/
    @Override
    public UserInfo findById(String userId) {
        return userDao.findById(userId);
    }
}
