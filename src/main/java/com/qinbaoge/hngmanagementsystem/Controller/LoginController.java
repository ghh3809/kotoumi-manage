package com.qinbaoge.hngmanagementsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.qinbaoge.hngmanagementsystem.Entity.Username;
import com.qinbaoge.hngmanagementsystem.Service.LoginService;
import com.qinbaoge.hngmanagementsystem.Util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.security.KeyPair;
import java.security.PrivateKey;

@Controller
public class LoginController {
    private String publicKeyStr;
    private String privateKeyStr;
    @Autowired
    private LoginService loginService;

    public LoginController() {
        try {
            KeyPair keyPair= RSAUtil.getKeyPair();
            publicKeyStr = RSAUtil.getPublicKey(keyPair);
            privateKeyStr = RSAUtil.getPrivateKey(keyPair);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("publicKeyStr",publicKeyStr);
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping(value="/validatelogin",method =RequestMethod.POST )
    @ResponseBody
    public String validatelogon(@RequestParam(value = "fjson") String fjson, HttpServletRequest request){
        System.out.println(fjson);
        Username username=null;
        try {

            PrivateKey privateKey = RSAUtil.string2PrivateKey(privateKeyStr);
            byte[] base642Byte = RSAUtil.base642Byte(fjson);
            username= JSON.parseObject(new String(RSAUtil.privateDecrypt(base642Byte, privateKey)),Username.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "error_3";
        }
        Username DBusername =loginService.find_this_username(username.getUsername());
        if(DBusername==null){
            return "error_1";
        }else if((!DBusername.getUsername().equals(username.getUsername()))||!(DBusername.getPassword().equals(username.getPassword()))){
            return "error_2";
        }else {
            HttpSession sessoin=request.getSession(true);
            sessoin.setAttribute("username",username.getUsername());
            sessoin.setAttribute("qq_number",DBusername.getQq_number());
            return "success";
        }


    }
}
