package com.shp.demo.admin.api.feign.client;


import com.shp.demo.admin.api.feign.fallback.ApiClientFallBack;
import com.shp.demo.common.feign.config.FeignRequestInterceptorConfig;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId = "apiClient",
        name = ServiceNameConstants.SPH_ADMIN, configuration = FeignRequestInterceptorConfig.class,
        fallback = ApiClientFallBack.class)
public interface ApiClient {

    @GetMapping("/api/principal")
    ApiResponse getUserInfo();

}
