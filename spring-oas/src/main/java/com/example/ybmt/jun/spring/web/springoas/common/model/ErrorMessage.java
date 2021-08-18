package com.example.ybmt.jun.spring.web.springoas.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String messageId;

    private String message;
    
}
