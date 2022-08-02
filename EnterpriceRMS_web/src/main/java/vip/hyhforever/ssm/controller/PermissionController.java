package vip.hyhforever.ssm.controller;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/2 , 10:42
 * 功能描述：
 * */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.hyhforever.ssm.domain.Permission;
import vip.hyhforever.ssm.service.IPermissionService;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
       permissionService.save(permission);
       return "redirect:findAll.do";
    }

}
