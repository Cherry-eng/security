package com.travel.service;

import com.travel.domain.TabCategory;
import com.travel.domain.TabUser;

import java.util.List;

public interface TravelCategoryService {
    public List<TabCategory> findAll(int page,int size);
    public void delete(Integer cid);
}
