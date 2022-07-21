package vip.hyhforever.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vip.hyhforever.ssm.domain.Product;
import vip.hyhforever.ssm.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 功能描述：查询所有产品信息
     * @return 查询所有的product产品信息，以productList的键值返回给当前session
     **/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Product> productList = productService.findAll();
        for (Product p : productList) {
            System.out.println(p);
            System.out.println(p.getDepartureTimeStr());
            System.out.println(p.getDepartureTimeStr());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 功能描述：添加的产品信息到数据库
     **/
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
