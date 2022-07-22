package vip.hyhforever.ssm.dao;

import org.apache.ibatis.annotations.*;
import vip.hyhforever.ssm.domain.Member;
import vip.hyhforever.ssm.domain.Orders;
import vip.hyhforever.ssm.domain.Product;

import java.util.List;

/*
* 实现vip.hyhforever.ssm.domain.Order类相关的持久化操作
* */
public interface IOrdersDao {

    /**
     * 功能描述：
     * @return 查询数据库中的所有信息并返回以List形式返回数据
     **/
    @Select("select  * from `order`")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "vip.hyhforever.ssm.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from `order` where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "vip.hyhforever.ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "vip.hyhforever.ssm.dao.IMember.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "vip.hyhforever.ssm.dao.ITraveller.findByOrdersId")),
    })
    Orders findById(String ordersId);
}
