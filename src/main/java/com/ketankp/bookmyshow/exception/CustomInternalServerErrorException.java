package com.ketankp.bookmyshow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomInternalServerErrorException extends RuntimeException{
    private String message;
    private Exception exception;
}
