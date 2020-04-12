package com.shp.demo.admin.biz.service.authority;

import com.shp.demo.admin.api.entity.authority.Authority;

import java.util.List;

public interface AuthorityService {

    /**
     * 根据用户id查询用户的权限
     *
     * @param id 用户id
     * @return List<Authority>
     */
    List<Authority> findAuthorityByUserId(Long id);
}
