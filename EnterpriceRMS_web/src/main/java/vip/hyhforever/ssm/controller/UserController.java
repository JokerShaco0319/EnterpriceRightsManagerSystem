package vip.hyhforever.ssm.controller;

/*
 * 作者：JokerShaco
 * 创建时间：2022/7/28 , 15:36
 * 功能描述：此Controller类负责处理所有关于用户实体类的操作请求
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 功能描述：根据Id查询用户的所有相关数据并返回user-show视图进行展示
     * @param userId 需要查询的用户Id
     * @return View 返回到user-show视图
     **/
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String userId) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findById(userId);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

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

    /**
     * 功能描述：将页面提交的用户信息存入数据库
     * @param userInfo 保存用户信息的对象
     * @return View 重定向到所有用户的数据展示页面
     **/
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        service.save(userInfo);
        return "redirect:findAll.do";
    }

}
