package com.shp.demo.common.security.service;

import com.alibaba.fastjson.JSON;
import com.shp.demo.admin.api.entity.authority.OauthClientDetails;
import com.shp.demo.admin.api.feign.client.AuthorityClient;
import com.shp.demo.common.base.enums.ShpHttpStatus;
import com.shp.demo.common.base.exception.CommonException;
import com.shp.demo.common.base.support.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ShpClientDetailsService implements ClientDetailsService {

    private  static  final Logger log = LoggerFactory.getLogger(ShpClientDetailsService.class);

    @Autowired
    private AuthorityClient authorityClient;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ApiResponse apiResponse = authorityClient.getOauthClientDetailsByClientId(clientId);
        OauthClientDetails model  = JSON.parseObject(JSON.toJSONString( apiResponse.getData(), true),OauthClientDetails.class);
        if (model == null) {
            throw new CommonException(ShpHttpStatus.CLIENT_ERROR);
        }
        BaseClientDetails clientDetails = new BaseClientDetails();
        //客户端(client)id
        clientDetails.setClientId(model.getClientId());
        //客户端所能访问的资源id集合
        if (StringUtils.isNotEmpty(model.getResourceIds())) {
            clientDetails.setResourceIds(Arrays.asList(model.getResourceIds().split(",")));
        }
        //客户端(client)的访问密匙
        clientDetails.setClientSecret(new BCryptPasswordEncoder().encode(model.getClientSecret()));
        //客户端支持的grant_type授权类型
        clientDetails.setAuthorizedGrantTypes(Arrays.asList(model.getAuthorizedGrantTypes().split(",")));
        //客户端申请的权限范围
        clientDetails.setScope(Arrays.asList(model.getScope().split(",")));
        Integer accessTokenValidity = model.getAccessTokenValidity();
        if (accessTokenValidity != null && accessTokenValidity > 0) {
            //设置token的有效期，不设置默认12小时
            clientDetails.setAccessTokenValiditySeconds(accessTokenValidity);
        }
        Integer refreshTokenValidity = model.getRefreshTokenValidity();
        if (refreshTokenValidity != null && refreshTokenValidity > 0) {
            //设置刷新token的有效期，不设置默认30天
            clientDetails.setRefreshTokenValiditySeconds(refreshTokenValidity);
        }
        clientDetails.isAutoApprove(model.getAutoapprove());
        log.debug("clientId是：" + clientId);
        return clientDetails;
    }
}
