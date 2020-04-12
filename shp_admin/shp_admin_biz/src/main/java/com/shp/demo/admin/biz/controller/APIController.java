package com.shp.demo.admin.biz.controller;

import com.shp.demo.admin.api.dto.UserDto;
import com.shp.demo.admin.api.entity.authority.Authority;
import com.shp.demo.admin.api.entity.role.Role;
import com.shp.demo.admin.api.entity.user.User;
import com.shp.demo.admin.api.vo.UserVo;
import com.shp.demo.admin.biz.service.authority.AuthorityService;
import com.shp.demo.admin.biz.service.role.RoleService;
import com.shp.demo.admin.biz.service.user.UserService;
import com.shp.demo.common.security.model.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.shp.demo.common.base.support.ApiResponse;
import com.shp.demo.common.base.support.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "用户登录")
public class APIController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/principal")
    @ApiOperation(value = "获取用户信息")
    public ApiResponse getUserInfo() {
        UserDto userDto = new UserDto();
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.loadUserByUserId(loginUser.getId());
        UserVo userVo = new UserVo();
        Role role = roleService.getRoleByUserId(loginUser.getId());
        List<Authority> authList = authorityService.findAuthorityByUserId(loginUser.getId());
        List<String> authCodeList = new ArrayList<>();
        List<String> roleCodeList = new ArrayList<>();
        List<String> menuCodeList = new ArrayList<>();
        for (Authority authority : authList) {
            authCodeList.add(authority.getAuthCode());
            menuCodeList.add(authority.getAuthCode());
        }
        roleCodeList.add(role.getRoleCode());
        BeanUtils.copyProperties(user, userVo);
        userDto.setSysUser(userVo);
        userDto.setPermissions(authCodeList);
        userDto.setRoles(roleCodeList);
        userDto.setMenus(menuCodeList);
        return success(userDto);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value = "登录接口")
    public ApiResponse webLogin(@RequestParam String userName, @RequestParam String password){
        UserVo result = userService.loginByPassword(userName, password);
        if(null != result){
            return success(result);
        }
        return fail("登陆失败");
    }


}
