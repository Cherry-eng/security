package com.travel.dao;

import com.travel.domain.TabFavorite;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TravelFavoriteDao {
    @Select("select * from tab_favorite")
    @Results({
            @Result(property = "rid" ,column = "rid"),
            @Result(property = "uid" ,column = "uid"),
            @Result(property = "date" ,column = "date"),
            @Result(property = "tabRoute",column = "rid",one=@One(select="com.travel.dao.TravelRouteDao.findRouteByRid")),
            @Result(property = "tabUser",column = "uid",one=@One(select="com.travel.dao.TravelUserDao.findUserByUid"))
    })
    public List<TabFavorite> findAll();
    @Insert("insert into tab_favorite (rid,date,uid) values (#{rid},#{date},#{uid})")
    public void save(TabFavorite tabFavorite);

    @Select("select * from tab_favorite where fid=#{fid}")
    @Results({
            @Result(property = "fid",column = "fid"),
            @Result(property = "rid" ,column = "rid"),
            @Result(property = "uid" ,column = "uid"),
            @Result(property = "date" ,column = "date"),
            @Result(property = "tabRoute",column = "rid",one=@One(select="com.travel.dao.TravelRouteDao.findRouteByRid")),
            @Result(property = "tabUser",column = "uid",one=@One(select="com.travel.dao.TravelUserDao.findUserByUid"))
    })
    public TabFavorite findByFid(int fid);
    @Update("update tab_favorite set rid=#{rid},date=#{date},uid=#{uid} where fid=#{fid}")
    public void alter(TabFavorite tabFavorite);
}
