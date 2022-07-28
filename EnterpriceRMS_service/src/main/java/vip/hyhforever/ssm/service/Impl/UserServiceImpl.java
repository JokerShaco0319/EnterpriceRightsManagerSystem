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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();//security的需要将密码加密后才能正确获取权限控制，如果数据库没有加密，需要调用加密

        return new User(userInfo.getUsername(),//用户名
                bCryptPasswordEncoder.encode(userInfo.getPassword()),//将密码加密
                userInfo.getStatus() == 0 ? false : true,//用户是否可用
                true, true, true,//其他权限控制
                getAuthority(userInfo.getRoles()));//角色信息
    }


    /**
     * 功能描述：根据用户的角色生成对应security权限
     * @param roles 当前用户对应的角色集合
     * @return List 返回一个security权限控制类的集合
     **/
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            Logger.getGlobal().info("角色信息：ROLE_" + role.getRoleName());
        }
        return list;
    }

}
