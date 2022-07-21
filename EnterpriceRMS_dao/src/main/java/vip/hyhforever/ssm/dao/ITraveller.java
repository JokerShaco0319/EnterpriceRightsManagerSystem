package vip.hyhforever.ssm.dao;

import org.apache.ibatis.annotations.Select;
import vip.hyhforever.ssm.domain.Traveller;

import java.util.List;

/*
* 实现vip.hyhforever.ssm.domain.traveller相关的持久化操作
* */
public interface ITraveller {
    /**
     * 功能描述：
     * @param ordersId 根据ordersId查询游客表中的多对多关系，并返回与此订单号有关的游客信息
     * @return 游客List集合
     **/
    @Select("select * from travellers where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
