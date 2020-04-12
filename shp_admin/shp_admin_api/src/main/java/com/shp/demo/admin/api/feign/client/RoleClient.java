package com.shp.demo.admin.api.feign.client;

import com.shp.demo.admin.api.feign.fallback.RoleClientFallBack;
import com.shp.demo.common.feign.config.FeignRequestInterceptorConfig;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "roleClient",
        name = ServiceNameConstants.SPH_ADMIN,
        configuration = FeignRequestInterceptorConfig.class, fallback = RoleClientFallBack.class)
public interface RoleClient {

    @GetMapping("/role/info/{id}")
    ApiResponse getRoleByUserId(@PathVariable Long id);
}
