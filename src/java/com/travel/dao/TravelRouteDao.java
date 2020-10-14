package com.travel.dao;

import com.travel.domain.TabRoute;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravelRouteDao {
    @Select("select * from tab_route")
    @Results({
            @Result(property = "rid" ,column = "rid"),
            @Result(property = "rname" ,column = "rname"),
            @Result(property = "price" ,column = "price"),
            @Result(property = "routeIntroduce" ,column = "routeIntroduce"),
            @Result(property = "rflag" ,column = "rflag"),
            @Result(property = "rdate" ,column = "rdate"),
            @Result(property = "isThemeTour" ,column = "isThemeTour"),
            @Result(property = "count" ,column = "count"),
            @Result(property = "rimage" ,column = "rimage"),
            @Result(property = "tabCategory",column = "cid",one=@One(select="com.travel.dao.TravelCategoryDao.findCategoryByCid")),
            @Result(property = "tabSeller",column = "sid",one=@One(select="com.travel.dao.TravelSellerDao.findSellerBySid"))
    })
    public List<TabRoute> findAll();
    @Select("select * from tab_route where rid=#{rid}")
    public TabRoute findRouteByRid(int rid);
}
