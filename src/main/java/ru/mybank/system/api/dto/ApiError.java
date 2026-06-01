package ru.mybank.system.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public record ApiError(
        HttpStatus status,
        String message,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime timestamp
) {
    public ApiError(HttpStatus status, String message){
        this(status, message, LocalDateTime.now());
    }
}
