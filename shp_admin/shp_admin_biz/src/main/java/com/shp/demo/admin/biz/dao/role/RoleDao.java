package com.shp.demo.admin.biz.dao.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shp.demo.admin.api.entity.role.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 根据用户id查询用户的角色
     *
     * @param userId 用户id
     * @return Role
     */
    Role getRoleByUserId(@Param(value = "userId") Long userId);
}
