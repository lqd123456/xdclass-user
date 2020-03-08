package com.xdclass.userapp.service.dubbo;

import com.xdclass.userapp.mapper.UserMapper;
import com.xdclass.userapp.model.User;
import com.xdclass.userserviceapi.DTO.UserVO;
import com.xdclass.userserviceapi.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * 用户服务层
 *
 * @author 梁庆德
 * @Date 2020/2/7 18:12
 */
@Service
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;

    /**
     * 根据主键id 获取用户信息
     *
     * @author 梁庆德
     * @date 2020年02月07日 18:14
     * @param id
     * @return
     */
    @Override
    public UserVO getUserById(Integer id)
    {
        User user = userMapper.selectByPrimaryKey(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);

        return userVO;
    }
}
