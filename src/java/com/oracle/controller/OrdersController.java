package com.oracle.controller;

import com.github.pagehelper.PageInfo;
import com.oracle.domain.Orders;
import com.oracle.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //[1]查询所有订单
    @RequestMapping("/findAll.do")
    @RolesAllowed("ROOT")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "2")int size) {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
        //System.out.println(ordersList);
        //如何讲分页后的数据信息显示到页面中
        PageInfo pageInfo=new PageInfo(ordersList);//相当于一个pojo类
        mv.setViewName("orders_list_page");//显示订单信息
        mv.addObject("pageInfo", pageInfo);//将分页后数据传入模板
        return mv;
    }
    //[2]订单详细信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id){//订单id
         Orders orders=ordersService.findById(id);
         ModelAndView mv=new ModelAndView();
         mv.addObject("ordersList",orders);
         mv.setViewName("orders_show");
         return mv;
    }
}
