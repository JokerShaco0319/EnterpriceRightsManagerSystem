package vip.hyhforever.ssm.controller;

import com.github.pagehelper.PageHelper;
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

/*
     * 功能描述：查询数据库的全部订单----未使用pageHelper完成分页查询
     * @return 返回一个以orderList为键值的类到当前session
     *
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = service.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }*/

    /**
     * 功能描述：通过分页查询的方式查询所有的订单内容
     * @param page 分页查询的页码
     * @param size 分页查询的条数
     * @return mv 以视图和模型的形式返回数据
     **/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "4")int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = service.findAll(page, size);
        //pageInfo本质上是一个page的bean
        PageInfo pageInfo = new PageInfo<>(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    /**
     * 功能描述：根据订单的id查询此订单所有的详细信息，包括订单产品信息、订单人员信息等
     * @param ordersId 需要查询的订单Id
     * @return mv
     **/
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = service.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
