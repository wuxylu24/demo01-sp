package com.shp.demo.auth.controller;

import com.shp.demo.admin.api.feign.client.ApiClient;
import com.shp.demo.admin.api.feign.client.UserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.shp.demo.common.base.support.ApiResponse;
import com.shp.demo.common.base.support.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/home")
@Api(tags = "auth")
public class HomeController extends BaseController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private TokenStore tokenStore;



    @GetMapping("/principal")
    @ApiOperation(value = "获取当前用户信息Principal")
    public Principal user(Principal member) {
        //获取当前用户信息
        return member;
    }


    @GetMapping("/test")
    public ApiResponse getUserInfo() {
        return apiClient.getUserInfo();
    }


    @GetMapping("/test/{userId}")
    public ApiResponse getUserByUserId(@PathVariable Long userId) {
        return userClient.getUserByUserId(userId);
    }

    /**
     * 清除token（注销登录）
     */
    @DeleteMapping("/logout")
    @ApiOperation(value = "登出")
    public ApiResponse logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        if (StringUtils.isBlank(authHeader)) {
            return fail("退出失败，token 为空");
        }
        //注销当前用户
        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StringUtils.EMPTY).trim();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
        tokenStore.removeAccessToken(accessToken);
        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
        tokenStore.removeRefreshToken(refreshToken);
        return success("注销成功");
    }

}
