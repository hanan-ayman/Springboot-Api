/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flairsteck.workshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hanan.ayman
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CodeNotFoundException extends Exception {

    public CodeNotFoundException(String exception) {
        super(exception);
    }
}
