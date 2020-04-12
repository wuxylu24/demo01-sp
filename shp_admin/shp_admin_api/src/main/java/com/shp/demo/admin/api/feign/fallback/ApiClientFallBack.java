package com.shp.demo.admin.api.feign.fallback;

import com.shp.demo.admin.api.feign.client.ApiClient;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApiClientFallBack implements ApiClient {

    private final Logger logger = LoggerFactory.getLogger(ApiClientFallBack.class);

    @Override
    public ApiResponse getUserInfo() {
        return ApiResponse.hystrixError(ServiceNameConstants.SPH_ADMIN , "getUserInfo");
    }

}
