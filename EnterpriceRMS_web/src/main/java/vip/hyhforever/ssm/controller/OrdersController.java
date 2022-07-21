package vip.hyhforever.ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.hyhforever.ssm.domain.Orders;
import vip.hyhforever.ssm.service.IOrdersService;

import java.util.List;

/*
* orderList页面的请求控制类
* */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    //自动注入一个订单服务类
    @Autowired
    private IOrdersService service;

    /**
     * 功能描述：
     * @param page 查询的页数 必须参数 默认值为 1
     * @param size 展示的数据条数 必须参数 默认值为 4
     * @return 返回一个以pageInfo为键值的类到当前session
     **/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = service.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }
}
