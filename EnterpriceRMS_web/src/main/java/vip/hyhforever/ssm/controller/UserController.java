package vip.hyhforever.ssm.controller;

/*
 * 作者：JokerShaco
 * 创建时间：2022/7/28 , 15:36
 * 功能描述：此Controller类负责处理所有关于用户实体类的操作请求
 * */

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vip.hyhforever.ssm.domain.UserInfo;
import vip.hyhforever.ssm.service.IUserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    /**
     * 功能描述：查询所有的用户信息
     * @return mv 返回UserInfo类的List集合
     **/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = service.findAll();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        service.save(userInfo);
        return "redirect:findAll.do";
    }
}
