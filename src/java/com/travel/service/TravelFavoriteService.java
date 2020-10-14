package com.travel.service;

import com.travel.domain.TabFavorite;

import java.util.List;

public interface TravelFavoriteService {
    public List<TabFavorite> findAll();
    public void save(TabFavorite tabFavorite);
    public TabFavorite findByFid(int fid);
    public void alter(TabFavorite favorite);
}
