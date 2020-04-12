package com.shp.demo.common.security.properties;

import lombok.Getter;
import lombok.Setter;
import com.shp.demo.common.base.enums.LoginType;


@Getter
@Setter
public class WebProperties {

    private String loginPage;
    // private String loginPage = GlobalsConstants.LOGIN_PAGE_URI;

    private LoginType loginType = LoginType.JSON;

    private String[] unInterceptUris = {};
}
