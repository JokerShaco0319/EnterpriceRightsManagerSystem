package vip.hyhforever.ssm.dao;

import org.apache.ibatis.annotations.Select;
import vip.hyhforever.ssm.domain.Member;

/*
* 实现vip.hyhforever.ssm.domain.Member类相关的持久化操作
* */
public interface IMember {
    /**
     * 功能描述：根据Id单独查询一个会员的信息
     **/
    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
