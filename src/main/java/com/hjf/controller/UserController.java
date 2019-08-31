package com.hjf.controller;

import com.hjf.model.UserDomain;
import com.hjf.properties.BoyProperties;
import com.hjf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BoyProperties boyProperties;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserDomain user, HttpServletRequest request){
        String userName = request.getParameter("userName");
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        logger.info("传入参数:"+pageNum+"--"+pageSize);

        logger.info(boyProperties.toString());//读取配置文件
        return userService.findAllUser(pageNum,pageSize);
    }
}
