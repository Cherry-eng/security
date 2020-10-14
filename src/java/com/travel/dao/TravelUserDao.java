package com.travel.dao;

import com.travel.domain.TabUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TravelUserDao {
    @Select("select * from tab_user")
    public List<TabUser> findAll(int page, int size);
    @Select("select * from tab_user")
    public List<TabUser> findAllNoPage();
    @Update("update tab_user set status='Y' where uid=#{uid}")
    public void active(int uid);
    @Select("select * from tab_user where username like concat('%',#{username},'%')")
    public List<TabUser> search(@Param("username") String username,@Param("page") int page,@Param("size") int size);
    @Select("select * from tab_user where uid=#{uid}")
    public TabUser findUserByUid(int uid);
}
