package com.flairsteck.workshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author hanan.ayman
 */

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

    @ExceptionHandler(DBDownException.class)
    public ResponseEntity<?> DBDownExceptionHandler() {
        ErrorResponse errorDetails
                = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), "INTERNAL_ERROR");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CodeNotFoundException.class)
    public ResponseEntity<?> CodeNotFoundExcpetionHandler() {
        ErrorResponse errorDetails
                = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), "INVALID_COUNTRY_CODE");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
