package com.shp.demo.admin.api.feign.fallback;

import com.shp.demo.admin.api.feign.client.RoleClient;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoleClientFallBack implements RoleClient {

    private final Logger logger = LoggerFactory.getLogger(RoleClientFallBack.class);

    @Override
    public ApiResponse getRoleByUserId(Long id) {
        return ApiResponse.hystrixError(ServiceNameConstants.SPH_ADMIN, "getRoleByUserId");
    }
}
