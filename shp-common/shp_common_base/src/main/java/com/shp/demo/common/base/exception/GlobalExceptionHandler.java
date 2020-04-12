package com.shp.demo.common.base.exception;

import com.shp.demo.common.base.enums.ShpHttpStatus;
import com.shp.demo.common.base.support.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = CommonException.class)
    public ApiResponse defaultErrorHandler(CommonException e) {
        e.printStackTrace();
        return new ApiResponse(ShpHttpStatus.COMMON_FAIL.getCode(),new CommonException().getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ApiResponse defaultErrorHandler(RuntimeException e) {
        e.printStackTrace();
        createLogger(e);
        return  new ApiResponse(ShpHttpStatus.SERVER_FUGUE.getCode(),ShpHttpStatus.SERVER_FUGUE.getMessage());
    }

    /**
     * 打印关键log信息
     * @param e
     */
    private void createLogger(Exception e) {
        logger.info(e.getMessage());
        logger.info(e.getStackTrace()[0].toString());
        logger.error(e.getMessage());
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            logger.error(stackTraceElement.toString());
        }
    }
}
