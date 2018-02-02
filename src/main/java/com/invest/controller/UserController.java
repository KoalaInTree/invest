package com.invest.controller;

import com.invest.common.ServerResponse;
import com.invest.pojo.User;
import com.invest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CJ on 2018-02-01.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService iUserService;
    @RequestMapping(value = "register")
    @ResponseBody

    public ServerResponse register(@Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ServerResponse.createByErrorMessage(bindingResult.getAllErrors().toString());
        }
       return iUserService.register(user);
    }

    @RequestMapping("login")
    @ResponseBody
    public ServerResponse login(@Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){

            return ServerResponse.createByErrorMessage(bindingResult.getAllErrors().toString());
        }
        return iUserService.login(user);
    }

    @RequestMapping("update")
    @ResponseBody
    public ServerResponse update(User user){
        if (user == null ||user.getId()==null){
            return ServerResponse.createByErrorMessage("系统错误(缺少用户id)");
        }
        return iUserService.updateInformation(user);
    }

    @RequestMapping("load/{id}")
    @ResponseBody
    public ServerResponse update(@PathVariable(value = "id")Integer id){
        if (id == null ){
            return ServerResponse.createByErrorMessage("系统错误(缺少用户id)");
        }
        return iUserService.findOne(id);
    }
}