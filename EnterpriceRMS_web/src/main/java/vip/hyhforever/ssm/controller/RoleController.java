package vip.hyhforever.ssm.controller;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/1 , 19:18
 * 功能描述：角色相关操作页面
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.hyhforever.ssm.domain.Permission;
import vip.hyhforever.ssm.domain.Role;
import vip.hyhforever.ssm.service.IRoleService;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = service.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 功能描述：保存一个角色到角色表
     * @param role 角色对象
     **/
    @RequestMapping("/save.do")
    public String save(@RequestParam(name = "role", required = true) Role role) throws Exception {
        service.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 功能描述：根据roleID查询当前角色未添加的权限
     **/
    @RequestMapping("/findUserByIdAndAllPermission.do")
    public ModelAndView findUserByIdAndAllPermission(@RequestParam(name = "id",required = true)String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleID查询role
        Role role = service.findById(roleId);
        //根据roleId查询当前Role可以添加的权限
        List<Permission> otherPermission = service.findOtherPermission(roleId);
        mv.addObject("permissionList",otherPermission);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * 功能描述：根据Id查询当前角色信息
     * @param roleId 需要查询的角色Id
     * @return Role 返回查询到的Role
     **/
    @RequestMapping("/findById.do")
    public Role findById(@RequestParam(name = "id",required = true)String roleId) throws Exception {
        return service.findById(roleId);
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids",required = true)String[] ids){
        service.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }
}
