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
import vip.hyhforever.ssm.domain.Role;
import vip.hyhforever.ssm.domain.UserInfo;
import vip.hyhforever.ssm.service.IUserService;

import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed("ADMIN")
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

    /**
     * 功能描述：查询用户以及用户可以添加的角色
     * @param userId get请求的参数，用户的唯一id，用于查询用户信息
     * @return 跳转到用户-角色展示页面
     **/
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true)String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.更具用户ID查询用户
        UserInfo userInfo = service.findById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = service.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 功能描述：给用户添加角色
     * @param userId 当前用户的唯一Id
     * @param ids 需要添加的多个角色的Id字符串数组
     * @return 页面重定向为：查询用户所有信息
     **/
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,@RequestParam(name = "ids",required = true)String[] ids){
        service.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }
}
