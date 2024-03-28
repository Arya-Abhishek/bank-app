package com.bank.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // To throw a detailed exception message, mentioning Customer/Accounts as resourceName,
    // mobileNumber as fieldName and the value of mobileNumber as fieldValue
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with given input data %s : '%s'", resourceName, fieldName, fieldValue));
    }
}