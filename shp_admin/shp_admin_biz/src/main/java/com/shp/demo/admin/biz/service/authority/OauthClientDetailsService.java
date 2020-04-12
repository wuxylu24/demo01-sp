package com.shp.demo.admin.biz.service.authority;

import com.shp.demo.admin.api.entity.authority.OauthClientDetails;

public interface OauthClientDetailsService{

    /**
     * 根据clientId查询OauthClientDetails
     *
     * @param clientId clientId
     * @return OauthClientDetails
     */
    OauthClientDetails findOauthClientDetailsByClientId(String clientId);

}
