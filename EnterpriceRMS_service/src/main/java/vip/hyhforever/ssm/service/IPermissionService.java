package vip.hyhforever.ssm.service;
/*
 * 作者：JokerShaco
 * 创建时间：2022/8/2 , 10:43
 * 功能描述：
 * */

import vip.hyhforever.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
