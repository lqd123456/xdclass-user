package com.xdclass.userserviceapi.service;

import com.xdclass.userserviceapi.DTO.UserVO;

/**
 * 用户接口
 *
 * @author 梁庆德
 * @date 2020年02月08日 13:24
 */
public interface UserService
{
    /**
     * 根据主键id 获取用户信息
     *
     * @author 梁庆德
     * @date 2020年02月07日 18:14
     * @param id
     * @return
     */
    public UserVO getUserById(Integer id);
}
