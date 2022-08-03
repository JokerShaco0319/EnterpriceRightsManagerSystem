package vip.hyhforever.ssm.controller;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/3 , 18:39
 * 功能描述：
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vip.hyhforever.ssm.domain.SysLog;
import vip.hyhforever.ssm.service.ISysLogService;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll();
        mv.addObject("sysLogs",sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
