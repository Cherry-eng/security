package com.travel.controller;

import com.github.pagehelper.PageInfo;
import com.travel.domain.TabCategory;
import com.travel.service.TravelCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/travel_category")
public class TravelCategoryController {
    @Autowired
    private TravelCategoryService travelCategoryService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "4")int size){
        List<TabCategory> categories=travelCategoryService.findAll(page,size);
        ModelAndView mv=new ModelAndView();
        PageInfo pageInfo=new PageInfo(categories);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("travel_category_list");
        return mv;
    }
    @RequestMapping("/delete.do")
    public String delete(Integer cid){
        travelCategoryService.delete(cid);
        return "redirect:/travel_category/findAll.do";
    }

}
