package com.shp.demo.admin.api.feign.client;

import com.shp.demo.admin.api.feign.fallback.AuthorityClientFallBack;
import com.shp.demo.common.feign.config.FeignRequestInterceptorConfig;
import com.shp.demo.common.base.constants.ServiceNameConstants;
import com.shp.demo.common.base.support.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "authorityClient",
        name = ServiceNameConstants.SPH_ADMIN,
        configuration = FeignRequestInterceptorConfig.class, fallback = AuthorityClientFallBack.class)
public interface AuthorityClient {

    @GetMapping("/authority/api/{id}")
    ApiResponse getAuthorityByUserId(@PathVariable Long id);

    @GetMapping("/authority/api/info")
    ApiResponse getOauthClientDetailsByClientId(@RequestParam String clientId);
}
