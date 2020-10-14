package com.travel.service.Impl;

import com.travel.dao.TravelRouteDao;
import com.travel.domain.TabRoute;
import com.travel.service.TravelRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelRouteServiceImpl implements TravelRouteService {

    @Autowired
    private TravelRouteDao travelRouteDao;
    @Override
    public List<TabRoute> findAll() {
        return travelRouteDao.findAll();
    }
}
