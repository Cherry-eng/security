package com.oracle.controller;

import com.oracle.domain.Product;
import com.oracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    //[1]查询所有商品信息
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Product> products=productService.findAll();
        System.out.println(products);
        mv.addObject("productList",products);
        mv.setViewName("product_list");//自动寻找pages/product_list.jsp
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Product product)throws Exception{
     productService.save(product);
     return "redirect:findAll.do";
    }
    @RequestMapping("/delete.do")
    public String delete(int id){
        System.out.println(id);
        productService.delete(id);
        return "redirect:findAll.do";
    }

}
