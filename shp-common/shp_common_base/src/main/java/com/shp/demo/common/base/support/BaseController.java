package com.shp.demo.common.base.support;

import com.shp.demo.common.base.constants.GlobalsConstants;
import com.shp.demo.common.base.enums.ShpHttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class BaseController {

    /**
     * session会话
     */
    protected HttpSession session;
    /**
     * httpRequest
     */
    protected HttpServletRequest request;

    /**
     * response
     */
    protected HttpServletResponse response;

    /**
     * 获取request、response、session
     */
    @ModelAttribute
    public void setRequest(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /**
     * 获取IP地址
     * @param request
     * @return
     */
    protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip) && !GlobalsConstants.UNKNOWN.equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !GlobalsConstants.UNKNOWN.equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public ApiResponse success(){
        return  new ApiResponse(ShpHttpStatus.SUCCESS);
    }

    public ApiResponse success(String msg){
        ApiResponse re = new ApiResponse(ShpHttpStatus.SUCCESS);
        re.setMessage(msg);
        return  re;
    }
    public ApiResponse success(Object data){
        ApiResponse re = new ApiResponse(ShpHttpStatus.SUCCESS);
        re.setData(data);
        return  re;
    }

    public ApiResponse fail(){
        return  new ApiResponse(ShpHttpStatus.COMMON_FAIL);
    }

    public ApiResponse fail(String msg){
        ApiResponse re = new ApiResponse(ShpHttpStatus.COMMON_FAIL);
        re.setMessage(msg);
        return  re;
    }

    public ApiResponse handle(boolean bl){
        if(bl){
            return success();
        }else {
            return fail();
        }
    }
}
