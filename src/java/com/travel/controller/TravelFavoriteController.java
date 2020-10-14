package com.travel.controller;

import com.github.pagehelper.PageInfo;
import com.travel.domain.TabFavorite;
import com.travel.domain.TabRoute;
import com.travel.domain.TabUser;
import com.travel.service.TravelFavoriteService;
import com.travel.service.TravelRouteService;
import com.travel.service.TravelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("travel_favorite")
public class TravelFavoriteController {
    @Autowired
    private TravelFavoriteService travelFavoriteService;
    @Autowired
    private TravelUserService travelUserService;
    @Autowired
    private TravelRouteService travelRouteService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        List<TabFavorite> favorites=travelFavoriteService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("favorites",favorites);
        mv.setViewName("travel_favorite_list");
        return mv;
    }
    @RequestMapping("/add.do")
    public ModelAndView add(){
        //[1]将用户信息传到jsp中
        List<TabUser> users = travelUserService.findAllNoPage();
        //[2]将线路信息传到jsp中
        List<TabRoute> routes = travelRouteService.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.addObject("routes",routes);

        mv.setViewName("travel_favorite_add");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(TabFavorite tabFavorite){
        travelFavoriteService.save(tabFavorite);
        return "redirect:/travel_favorite/findAll.do";
    }
    //修改回显模块
    @RequestMapping("/modify.do")
    public ModelAndView findByFid(int fid){
        //[1]将用户信息传到jsp中
        List<TabUser> users = travelUserService.findAllNoPage();
        //[2]将线路信息传到jsp中
        List<TabRoute> routes = travelRouteService.findAll();

        TabFavorite favorite=travelFavoriteService.findByFid(fid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("favorite",favorite);
        mv.addObject("users",users);
        mv.addObject("routes",routes);
        mv.setViewName("travel_favorite_modify");
        return mv;
    }
    //修改数据库模块
    @RequestMapping("/alter.do")
    public String alter(TabFavorite tabFavorite){
        travelFavoriteService.alter(tabFavorite);
        return "redirect:/travel_favorite/findAll.do";
    }
}
