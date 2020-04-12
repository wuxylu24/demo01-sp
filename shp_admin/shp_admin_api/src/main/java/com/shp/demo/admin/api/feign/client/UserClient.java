package com.shp.demo.admin.api.feign.client;

import com.shp.demo.admin.api.feign.fallback.UserClientFallBack;
import com.shp.demo.common.feign.config.FeignRequestInterceptorConfig;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "userClient",
        name = ServiceNameConstants.SPH_ADMIN,
        configuration = FeignRequestInterceptorConfig.class,
        fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/user/api")
    ApiResponse getUserByUserName(@RequestParam String username);

    @GetMapping("/user/info/{id}")
    ApiResponse getUserByUserId(@PathVariable Long id);
}
