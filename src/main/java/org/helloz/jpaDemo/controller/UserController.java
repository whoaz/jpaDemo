package org.helloz.jpaDemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.helloz.jpaDemo.model.User;
import org.helloz.jpaDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by helloz on 2016/9/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String show(Integer id) {
        User user = userService.findById(id);
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            json = mapper.writeValueAsString(user);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/add")
    public User add(String account,String pwd){
        User user = userService.addUser(account, pwd);

        return user;
    }

    @RequestMapping("find")
    public User find(String account){
        User user = userService.find(account);
        return user;
    }

}
