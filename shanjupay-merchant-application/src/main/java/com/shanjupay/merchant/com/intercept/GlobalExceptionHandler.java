package com.shanjupay.merchant.com.intercept;

import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.common.domain.CommonErrorCode;
import com.shanjupay.common.domain.ErrorCode;
import com.shanjupay.common.domain.RestErrorResponse;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */

//与ExcaptionHanler配合使用实现全局异常处理

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER =  LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 捕获异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse processException(HttpServletResponse response, HttpServletRequest request,Exception e){
//        解析异常信息
//        如果是系统自定义异常，直接取出code和message
        if(e instanceof BusinessException){
            LOGGER.warn(e.getMessage(),e);
//            解析系统自定义异常信息
            BusinessException businessException = (BusinessException) e;
            ErrorCode errorCode = businessException.getErrorCode();
//            错误代码
            int code = errorCode.getCode();
//            错误信息
            String desc = errorCode.getDesc();
            return new RestErrorResponse(desc,String.valueOf(code));
        }
//        不是自定义异常，统一输出错误
        LOGGER.error("系统异常");
        return new RestErrorResponse(CommonErrorCode.UNKOWN.getDesc(),String.valueOf(CommonErrorCode.UNKOWN.getCode()));
    }
}
