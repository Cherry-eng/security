package com.travel.service.Impl;

import com.travel.dao.TravelFavoriteDao;
import com.travel.domain.TabFavorite;
import com.travel.service.TravelFavoriteService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TravelFavoriteServiceImpl implements TravelFavoriteService {
    @Autowired
    private TravelFavoriteDao travelFavoriteDao;
    @Override
    public List<TabFavorite> findAll() {
        return travelFavoriteDao.findAll();
    }

    @Override
    public void save(TabFavorite tabFavorite) {
        travelFavoriteDao.save(tabFavorite);
    }

    @Override
    public TabFavorite findByFid(int fid) {
        return travelFavoriteDao.findByFid(fid);
    }

    @Override
    public void alter(TabFavorite favorite) {
        travelFavoriteDao.alter(favorite);
    }
}
