package com.travel.dao;

import com.travel.domain.TabCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravelCategoryDao {
    @Select("select * from tab_category")
    public List<TabCategory> findAll(int page,int size);
    @Delete("delete from tab_category where cid=#{cid}")
    public void delete(Integer cid);

    @Select("select * from tab_category where cid=#{cid}")
    public TabCategory findCategoryByCid(int cid);
}
