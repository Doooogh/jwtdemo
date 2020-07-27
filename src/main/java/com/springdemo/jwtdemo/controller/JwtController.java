package com.springdemo.jwtdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.springdemo.jwtdemo.entity.User;
import com.springdemo.jwtdemo.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/26 16:35
 * @Version 1.0
 **/
@RestController
public class JwtController {




    @GetMapping("/getTestInfo")
    public String test(String testStr){
        return "testInfo"+",,,"+testStr;
    }


    @PostMapping("/getToken")
    public String getToken( User user){
        return  JwtUtils.getToken(user.getUsername(),user.getPassword());
    }
    @PostMapping("/getToken1")
    public String getToken1( String username,String password){
        return "";
    }

    @PostMapping("/getToken2")
    public String getToken2(@RequestBody  JSONObject jsonObject){
        System.out.println(jsonObject);
        return jsonObject.toJSONString();
    }

    @DeleteMapping("/deleteById")
    public String deleteById(String id){
        return id+"delete success";
    }
}
