package com.shp.demo.admin.biz.service.authority.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shp.demo.admin.api.entity.authority.Authority;
import com.shp.demo.admin.biz.dao.authority.AuthorityDao;
import com.shp.demo.admin.biz.service.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authorityService")
public class AuthorityServiceImpl extends ServiceImpl<AuthorityDao, Authority> implements AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public List<Authority> findAuthorityByUserId(Long id) {
        return authorityDao.findAuthorityByUserId(id);
    }
}
