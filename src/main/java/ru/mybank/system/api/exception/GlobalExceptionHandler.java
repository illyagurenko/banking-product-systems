package ru.mybank.system.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.mybank.system.api.dto.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFound(EntityNotFoundException e){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError(status, e.getMessage());
        return new ResponseEntity<>(apiError, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAllException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = new ApiError(status, "server error");
        return new ResponseEntity<>(apiError, status);
    }
}
