package com.shp.demo.common.base.support;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.shp.demo.common.base.enums.ShpHttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object data;

    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ApiResponse(ShpHttpStatus sphHttpStatus) {
        this.code = sphHttpStatus.getCode();
        this.message = sphHttpStatus.getMessage();
    }


    /**
     * 调用服务的错误
     * @param serviceName 服务名
     * @param methodName 方法名
     * @return 结果视图
     */
    public static ApiResponse hystrixError(String serviceName,String methodName) {
        String msg = ShpHttpStatus.HYSTRIX_ERROR.getMessage().replace("xxx", serviceName).replace("{}", methodName);
        return new ApiResponse(ShpHttpStatus.HYSTRIX_ERROR.getCode(), msg);
    }
}
