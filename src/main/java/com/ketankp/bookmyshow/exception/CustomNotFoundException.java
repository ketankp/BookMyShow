package com.ketankp.bookmyshow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomNotFoundException extends RuntimeException{
    private String message;
    private String details;
}
