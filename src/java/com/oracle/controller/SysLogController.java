package com.oracle.controller;

import com.oracle.domain.SysLog;
import com.oracle.service.SysLogService;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysLog")
public class SysLogController {
    @Autowired
    public SysLogService sysLogService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        List<SysLog> sysLogList=sysLogService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("sysLogs",sysLogList);
        mv.setViewName("syslog_list");
        return mv;
    }
    @RequestMapping("deleteBatch.do")
    public String deleteBatch(int[] ids){
        sysLogService.deleteBatch(ids);
        return "redirect:findAll.do";
    }
}
