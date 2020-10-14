package com.oracle.dao;

import com.oracle.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    //[1]通过订单id查找旅客列表信息
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    public List<Traveller> findTravellersByOrdersId(int id);
}
