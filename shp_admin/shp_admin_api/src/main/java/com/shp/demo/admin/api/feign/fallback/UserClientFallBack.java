package com.shp.demo.admin.api.feign.fallback;

import com.shp.demo.admin.api.feign.client.UserClient;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class UserClientFallBack implements UserClient {

    private final Logger logger = LoggerFactory.getLogger(UserClientFallBack.class);

    @Override
    public ApiResponse getUserByUserName(String username) {
        return ApiResponse.hystrixError(ServiceNameConstants.SPH_ADMIN, "getUserByUserName");
    }

    @Override
    public ApiResponse getUserByUserId(Long id) {
        return ApiResponse.hystrixError(ServiceNameConstants.SPH_ADMIN, "getUserByUserId");
    }
}
