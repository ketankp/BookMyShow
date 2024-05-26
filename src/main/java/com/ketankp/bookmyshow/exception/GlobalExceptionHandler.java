package com.ketankp.bookmyshow.exception;

import com.ketankp.bookmyshow.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.text.SimpleDateFormat;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto customBadRequestException(CustomBadRequestException customBadRequestException, HttpServletRequest httpServletRequest, HandlerMethod handlerMethod){
        String declaringClass = handlerMethod.getMethod().getDeclaringClass().getSimpleName();
        String methodName = handlerMethod.getMethod().getName();
        log.error("Error in {}:{} method",declaringClass,methodName);
        return ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(customBadRequestException.getMessage())
                .details(customBadRequestException.getDetails())
                .timestamp(sdf.format(System.currentTimeMillis()))
                .path(httpServletRequest.getRequestURI())
                .build();
    }

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto customNotFoundException(CustomNotFoundException customNotFoundException, HttpServletRequest httpServletRequest, HandlerMethod handlerMethod){
        String declaringClass = handlerMethod.getMethod().getDeclaringClass().getSimpleName();
        String methodName = handlerMethod.getMethod().getName();
        log.error("Error in {}:{} method",declaringClass,methodName);
        return ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(customNotFoundException.getMessage())
                .details(customNotFoundException.getDetails())
                .timestamp(sdf.format(System.currentTimeMillis()))
                .path(httpServletRequest.getRequestURI())
                .build();
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto customInternalServerErrorException(CustomInternalServerErrorException customInternalServerErrorException, HttpServletRequest httpServletRequest, HandlerMethod handlerMethod){
        String declaringClass = handlerMethod.getMethod().getDeclaringClass().getSimpleName();
        String methodName = handlerMethod.getMethod().getName();
        log.error("Error in {}:{} method",declaringClass,methodName,customInternalServerErrorException.getException());
        return ErrorResponseDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(customInternalServerErrorException.getMessage())
                .details(customInternalServerErrorException.getException().getMessage())
                .timestamp(sdf.format(System.currentTimeMillis()))
                .path(httpServletRequest.getRequestURI())
                .build();
    }
}
