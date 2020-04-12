package com.shp.demo.common.security.util;

import com.shp.demo.common.security.model.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static LoginUser getLoginUser() {
        return (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
