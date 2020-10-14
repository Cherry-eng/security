package com.oracle.controller;

import com.github.pagehelper.PageInfo;
import com.oracle.dao.PermissionDao;
import com.oracle.domain.Permission;
import com.oracle.domain.Role;
import com.oracle.service.PermissionService;
import com.oracle.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    public RoleService roleService;
    @Autowired
    public PermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "2")int size){
        ModelAndView mv=new ModelAndView();
        List<Role> roleList=roleService.findAll(page,size);
        //如何将分页后的数据信息显示到页面中
        PageInfo pageInfo=new PageInfo(roleList);//相当于一个pojo类
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role_list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(int id){
        ModelAndView mv=new ModelAndView();
        //[1]通过角色id查找角色信息(回显到jsp页面)
        Role role=roleService.findRoleById(id);
        //[2]通过角色id查找到该角色没有的权限（显示到页面中）
        List<Permission> permissions=permissionService.findOtherPermission(id);
        //[3]将数据信息传入到网页中
        mv.addObject("role",role);
        mv.addObject("permissionList",permissions);
        mv.setViewName("role_permission_add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(int roleId,int[] ids){
        roleService.addPermission(roleId,ids);
        return "redirect:findAll.do";
    }
}
