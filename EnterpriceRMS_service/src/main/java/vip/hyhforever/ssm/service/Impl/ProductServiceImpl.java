package vip.hyhforever.ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.hyhforever.ssm.domain.Product;
import vip.hyhforever.ssm.service.IProductService;
import vip.hyhforever.ssm.dao.IProductDao;

import java.util.List;

@Service//申明为Service层的类
@Transactional//声明事务
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception{
        productDao.save(product);
    }

    @Override
    public Product findById(String id) throws Exception {
        return productDao.findById(id);
    }
}
