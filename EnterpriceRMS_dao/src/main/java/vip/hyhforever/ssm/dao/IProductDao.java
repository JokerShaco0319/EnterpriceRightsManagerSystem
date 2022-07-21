package vip.hyhforever.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import vip.hyhforever.ssm.domain.Product;

/*
* 此接口对应domain类中的Product类，实现对Product表的一系列持久化操作
* */
public interface IProductDao {

    /**
     * 功能描述：查询product表中的全部数据并封装为一个List<Product>集合
     * @return ProductList
     **/
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 功能描述：根据Id查询一个单独的产品
     **/
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;

    /**
     * 功能描述：保存一个新的产品信息
     **/
    @Insert("insert into product(productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
