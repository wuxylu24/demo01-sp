package com.shp.demo.admin.api.feign.fallback;

import com.shp.demo.admin.api.feign.client.AuthorityClient;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthorityClientFallBack implements AuthorityClient {

    private final Logger logger = LoggerFactory.getLogger(AuthorityClientFallBack.class);

    @Override
    public ApiResponse getAuthorityByUserId(Long id) {
        return ApiResponse.hystrixError(ServiceNameConstants.SPH_ADMIN, "getAuthorityByUserId");
    }

    @Override
    public ApiResponse getOauthClientDetailsByClientId(String clientId) {
        return ApiResponse.hystrixError(ServiceNameConstants.SPH_ADMIN, "getOauthClientDetailsByClientId");
    }
}
