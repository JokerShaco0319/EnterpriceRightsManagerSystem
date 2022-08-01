package vip.hyhforever.ssm.controller;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/1 , 19:18
 * 功能描述：角色相关操作页面
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        service.save(role);
        return "redirect:findAll.do";
    }

}
