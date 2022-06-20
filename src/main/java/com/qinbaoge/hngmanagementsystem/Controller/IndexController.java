package com.qinbaoge.hngmanagementsystem.Controller;

import com.qinbaoge.hngmanagementsystem.Entity.Unit;
import com.qinbaoge.hngmanagementsystem.Service.PoolService;
import com.qinbaoge.hngmanagementsystem.Service.UnitService;
import com.qinbaoge.hngmanagementsystem.Util.QQUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private PoolService poolService;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession sessoin = request.getSession(true);
        mv.addObject("qq_number", sessoin.getAttribute("qq_number"));
        mv.setViewName("index");
        return mv;

    }

    @RequestMapping("/error_info")
    public ModelAndView error_info() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        return mv;

    }

    @PostMapping("/qq/{qq}")
    @ResponseBody
    public String qq(@PathVariable("qq") String qq) {
        return QQUtil.getQQInfo(qq).getName();
    }


    @RequestMapping("/pool_info")
    public ModelAndView pool_info(){
        ModelAndView mv =new ModelAndView();
        mv.addObject("type_group",poolService.FindAllPoolType());
        mv.setViewName("pool_info");
        return mv;
    }
    @RequestMapping("/pool_add")
    public ModelAndView pool_add(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("pool_add");
        return mv;
    }


    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("welcome");
        String springVersion = SpringVersion.getVersion();
        String springBootVersion = SpringBootVersion.getVersion();
        mv.addObject("springVersion",springVersion);
        mv.addObject("springBootVersion",springBootVersion);
        mv.addObject("OS_name",System.getProperties().getProperty("os.name"));
        mv.addObject("Java_Version",System.getProperties().getProperty("java.version"));
        return mv;
    }

}