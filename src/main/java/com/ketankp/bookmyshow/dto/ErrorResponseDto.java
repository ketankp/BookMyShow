package com.ketankp.bookmyshow.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {

    private String code;
    private String message;
    private String details;
    private Timestamp timestamp;
    private String path;

}
