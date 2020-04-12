package com.shp.demo.common.base.exception;


import com.shp.demo.common.base.enums.ShpHttpStatus;


public class CommonException extends RuntimeException {

    public Integer code;

    public String msg;

    public CommonException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String msg) {
        super(msg);
        this.code = ShpHttpStatus.COMMON_FAIL.getCode();
        this.msg = msg;
    }

    public CommonException() {
        super(ShpHttpStatus.COMMON_FAIL.getMessage());
        this.code = ShpHttpStatus.COMMON_FAIL.getCode();
        this.msg = ShpHttpStatus.COMMON_FAIL.getMessage();
    }
    public CommonException(ShpHttpStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.msg = status.getMessage();
    }

    public CommonException(Throwable cause) {
        super(cause);
    }


}
