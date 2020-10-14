package com.travel.service;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.travel.domain.TabUser;

import java.util.List;

public interface TravelUserService {
    public List<TabUser> findAll(int page, int size);
    public void active(int[] uids);
    public List<TabUser> search(String username,int page,int size);
    public List<TabUser> findAllNoPage();
}
