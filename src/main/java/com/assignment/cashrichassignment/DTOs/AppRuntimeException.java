package com.assignment.cashrichassignment.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AppRuntimeException {
    public String message;
    public String timestamp;
}
