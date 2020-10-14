package com.travel.dao;

import com.travel.domain.TabSeller;
import org.apache.ibatis.annotations.Select;

public interface TravelSellerDao {
    @Select("select * from tab_seller where sid=#{sid}")
    public TabSeller findSellerBySid(int sid);
}
