package com.shp.demo.admin.biz.service.role;


import com.shp.demo.admin.api.entity.role.Role;

public interface RoleService {


    /**
     * 根据用户id查询用户的角色
     *
     * @param userId 用户id
     * @return Role
     */
    Role getRoleByUserId(Long userId);
}
