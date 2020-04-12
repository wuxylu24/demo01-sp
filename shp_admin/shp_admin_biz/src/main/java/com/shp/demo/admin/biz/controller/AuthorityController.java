package com.shp.demo.admin.biz.controller;

import com.shp.demo.admin.biz.service.authority.AuthorityService;
import com.shp.demo.admin.biz.service.authority.OauthClientDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.shp.demo.common.base.support.ApiResponse;
import com.shp.demo.common.base.support.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authority")
@Api(tags = "权限管理")
public class AuthorityController extends BaseController {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private OauthClientDetailsService oauthClientDetailsService;

    @GetMapping("/api/{id}")
    @ApiOperation(value = "根据用户id获取用户权限信息")
    public ApiResponse getAuthorityByUserId(@PathVariable Long id) {
        return success(authorityService.findAuthorityByUserId(id));
    }

    @GetMapping("/api/info")
    @ApiOperation(value = "根据clientId获取认证客户端详情信息")
    public ApiResponse getOauthClientDetailsByClientId(@RequestParam String clientId) {
        return success(oauthClientDetailsService.findOauthClientDetailsByClientId(clientId));
    }



}
