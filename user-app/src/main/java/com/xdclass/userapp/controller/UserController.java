package com.xdclass.userapp.controller;

import com.xdclass.userapp.service.dubbo.UserServiceImpl;
import com.xdclass.userserviceapi.DTO.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 用户控制层
 *
 * @author 梁庆德
 * @Date 2020/2/7 18:12
 */
@Controller
public class UserController
{
    @Resource
    private UserServiceImpl userServiceImpl;

    @GetMapping("/getUserById")
    @ResponseBody
    public UserVO getUserById(Integer id)
    {
        if (id == null)
        {
            return new UserVO();
        }

        return userServiceImpl.getUserById(id);
    }
}
