package com.hjf.controller;

import com.hjf.model.UserDomain;
import com.hjf.utils.Result;
import com.hjf.utils.ResultUtil;
import com.hjf.utils.properties.BoyProperties;
import com.hjf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    public Result<Integer> addUser(@Valid UserDomain user, BindingResult bindingResult,HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        String userName = request.getParameter("userName");
        return ResultUtil.success(userService.addUser(user));
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
