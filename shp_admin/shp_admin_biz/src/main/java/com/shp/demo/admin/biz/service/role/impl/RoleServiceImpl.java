package com.shp.demo.admin.biz.service.role.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shp.demo.admin.api.entity.role.Role;
import com.shp.demo.admin.biz.dao.role.RoleDao;
import com.shp.demo.admin.biz.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private  RoleDao roleDao;

    @Override
    public Role getRoleByUserId(Long userId) {
        return roleDao.getRoleByUserId(userId);
    }
}
