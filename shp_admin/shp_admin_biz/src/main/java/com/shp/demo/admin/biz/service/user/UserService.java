package com.shp.demo.admin.biz.service.user;


import com.shp.demo.admin.api.entity.user.User;
import com.shp.demo.admin.api.vo.UserVo;

import java.util.List;

public interface UserService {

    /**
     * 根据用户名称查询用户
     *
     * @param username 用户名
     * @return User
     */
    User loadUserByUserName(String username);

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return User
     */
    User loadUserByUserId(Long userId);

    /**
     * 根据用户名称查询所有相同用户名的用户
     *
     * @param username 用户名
     * @return List<UserVo>
     */
    List<UserVo> findUserVoList(String username);
    /**
     * 用户 用户名和密码登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return UserVo
     * */
    UserVo loginByPassword(String userName, String password);
}
