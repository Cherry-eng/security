package com.oracle.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.oracle.domain.Role;
import com.oracle.domain.UserInfo;
import com.oracle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.awt.event.MouseListener;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "size",required = true,defaultValue = "2")int size){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> users=userService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(users);
        mv.addObject("userList",pageInfo);
        mv.setViewName("user_list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id){
        ModelAndView mv=new ModelAndView();
        UserInfo user=userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user_show");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(int id){
        //[1]id就是用户的主键
        ModelAndView mv=new ModelAndView();
        //[2]用户没有的角色
        List<Role> roles=userService.findRoleById(id);
        //[3]通过用户id查找用户对象
        UserInfo user=userService.findById(id);
        mv.addObject("roleList",roles);
        mv.addObject("user",user);
        mv.setViewName("user_role_add");
        return mv;
    }
    //添加用户角色信息
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(int userId,int[] ids){//usereId（隐藏域） ids（复选框）
        userService.addRoleToUser(userId,ids);
        return "redirect:/user/findAll.do";
    }
}
