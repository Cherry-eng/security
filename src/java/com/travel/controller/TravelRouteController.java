package com.travel.controller;

import com.travel.domain.TabRoute;
import com.travel.domain.TabUser;
import com.travel.service.TravelRouteService;
import com.travel.service.TravelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/travel_route")
public class TravelRouteController {
     @Autowired
    private TravelRouteService travelRouteService;
     @Autowired
     private TravelUserService travelUserService;
     @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
         ModelAndView mv=new ModelAndView();
         List<TabRoute> routes=travelRouteService.findAll();
         mv.addObject("routes",routes);
         mv.setViewName("travel_route_list");
         return mv;
     }
     @RequestMapping("/add.do")
    public ModelAndView add(int page,int size){
         List<TabUser> users=travelUserService.findAll(page,size);
         ModelAndView mv=new ModelAndView();
         mv.setViewName("travel_favorite_add");
         return mv;
     }

}
