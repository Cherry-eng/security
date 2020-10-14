package com.travel.service.Impl;

import com.github.pagehelper.PageHelper;
import com.travel.dao.TravelUserDao;
import com.travel.domain.TabUser;
import com.travel.service.TravelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelUserServiceImpl implements TravelUserService {
    @Autowired
    private TravelUserDao travelUserDao;
    @Override
    public List<TabUser> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return travelUserDao.findAll(page,size);
    }

    @Override
    public void active(int[] uids) {
        for (int uid:uids){
            travelUserDao.active(uid);
        }
    }

    @Override
    public List<TabUser> search(String username,int page,int size) {
        PageHelper.startPage(page,size);
        return travelUserDao.search(username,page,size);
    }

    @Override
    public List<TabUser> findAllNoPage() {
        return travelUserDao.findAllNoPage();
    }
}
