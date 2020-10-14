package com.travel.controller;

import com.github.pagehelper.PageInfo;
import com.travel.domain.TabUser;
import com.travel.service.TravelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/travel_user")
public class TravelUserController {
    @Autowired
    private TravelUserService travelUserService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        List<TabUser> tab_users=travelUserService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(tab_users);
        mv.setViewName("travel_user_list");//显示订单信息
        mv.addObject("pageInfo", pageInfo);//将分页后数据传入模板
        return mv;
    }
    @RequestMapping("/active.do")
    public String active(int[] uids){
        travelUserService.active(uids);
        return "redirect:/travel_user/findAll.do";
    }
    @RequestMapping("/search.do")
    public ModelAndView search(String username,@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "1")int size){
        ModelAndView mv = new ModelAndView();
       List<TabUser> tabUsers= travelUserService.search(username,page,size);
        PageInfo pageInfo=new PageInfo(tabUsers);
        mv.setViewName("travel_user_list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
