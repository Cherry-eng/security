package com.oracle.controller;

import com.github.pagehelper.PageInfo;
import com.oracle.domain.Permission;
import com.oracle.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    public PermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "2")int size){
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList=permissionService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(permissionList);
        mv.addObject("permissionList",pageInfo);
        mv.setViewName("permission_list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission){
    permissionService.save(permission);
    return "redirect:findAll.do";
    }
}
