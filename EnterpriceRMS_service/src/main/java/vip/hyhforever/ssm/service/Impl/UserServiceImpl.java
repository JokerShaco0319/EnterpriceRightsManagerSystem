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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            Logger.getGlobal().info("用户查找失败");
            e.printStackTrace();
        }
        //使用Spring security的规范User对象 封装 自定义的User对象

        assert userInfo != null;
        String passwordEncode = bCryptPasswordEncoder.encode(userInfo.getPassword());

        return new User(userInfo.getUsername(), passwordEncode,getAuthority());
    }


    //测试方法：为当前登录的用户添加一个管理员权限认证
    public List<SimpleGrantedAuthority> getAuthority(){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }

}
