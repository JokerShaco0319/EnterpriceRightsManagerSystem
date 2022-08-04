package vip.hyhforever.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.hyhforever.ssm.dao.IOrdersDao;
import vip.hyhforever.ssm.domain.Orders;
import vip.hyhforever.ssm.service.IOrdersService;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 功能描述：多表查询所有订单的数据并以List集合的方式返回；
     * @param page 页码值；
     * @param size 每页显示显示的条目数；
     * @return 返回Dao查询到的所有订单数据；
     **/
    @Override
    public List<Orders> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    /**
     * 功能描述：根据Id返回一个订单的信息
     * @param ordersId 字符串类型 32位的uuid订单号
     * @return Order类 根据订单Id查询一个订单信息并以Order类的方式返回
     **/
    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
