package com.ketankp.bookmyshow.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {

    private String code;
    private String message;
    private String details;
    private String timestamp;
    private String path;

}
