package vip.hyhforever.ssm.service;

import java.util.List;
import vip.hyhforever.ssm.domain.Product;

public interface IProductService {

    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    Product findById(String id) throws Exception;
}
