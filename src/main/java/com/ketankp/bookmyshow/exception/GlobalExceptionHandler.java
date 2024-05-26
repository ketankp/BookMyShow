package com.ketankp.bookmyshow.exception;

import com.ketankp.bookmyshow.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto customBadRequestException(CustomBadRequestException customBadRequestException, HttpServletRequest httpServletRequest){
        return ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(customBadRequestException.getMessage())
                .details(customBadRequestException.getDetails())
                .timestamp( new Timestamp(System.currentTimeMillis()))
                .path(httpServletRequest.getRequestURI())
                .build();
    }

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto customNotFoundException(CustomNotFoundException customNotFoundException, HttpServletRequest httpServletRequest){
        return ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(customNotFoundException.getMessage())
                .details(customNotFoundException.getDetails())
                .timestamp( new Timestamp(System.currentTimeMillis()))
                .path(httpServletRequest.getRequestURI())
                .build();
    }
}
