package com.travel.service.Impl;

import com.github.pagehelper.PageHelper;
import com.travel.dao.TravelCategoryDao;
import com.travel.domain.TabCategory;
import com.travel.service.TravelCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TravelCategoryServiceImpl implements TravelCategoryService {
    @Autowired
    private TravelCategoryDao travelCategoryDao;

    @Override
    public List<TabCategory> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return travelCategoryDao.findAll(page,size);
    }

    @Override
    public void delete(Integer cid) {
        travelCategoryDao.delete(cid);
    }
}
