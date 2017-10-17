package com.wtc.admin.performance.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.wtc.admin.performance.exception.BussinessException;
import com.wtc.admin.performance.model.RestResponse;
import com.wtc.admin.performance.utils.RestGenerator;
import com.wtc.admin.performance.utils.WebContextUtil;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.NoHandlerFoundException;


import lombok.extern.slf4j.Slf4j;

/**
 * @author songce
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Resource
    private ErrorAttributes errorAttributes;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResponse<?> defaultErrorHandler(HttpServletRequest req, Exception e) {
        ServletRequestAttributes attributes = new ServletRequestAttributes(req, WebContextUtil.getResponse());
        Map<String, Object> attr = errorAttributes.getErrorAttributes(attributes, true);
        log.error("{}", attr);
        return RestGenerator.errorResult(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestResponse<?> noHandlerFoundExceptionHandler(HttpServletRequest req, NoHandlerFoundException e) {
        return RestGenerator.errorResult(e.getClass().getSimpleName(), e.getMessage());
    }
    
    @ExceptionHandler(value = BussinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResponse<?> noHandlerFoundExceptionHandler(HttpServletRequest req, BussinessException e) {
        return RestGenerator.errorResult(e.getClass().getSimpleName(), e.getMessage());
    }

}
