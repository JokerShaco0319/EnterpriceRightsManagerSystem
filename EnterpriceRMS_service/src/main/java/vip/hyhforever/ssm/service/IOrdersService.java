package vip.hyhforever.ssm.service;

import vip.hyhforever.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(Integer page, Integer size) throws Exception;

    List<Orders> findAll() throws Exception;

    Orders findById(String ordersId) throws Exception;
}
