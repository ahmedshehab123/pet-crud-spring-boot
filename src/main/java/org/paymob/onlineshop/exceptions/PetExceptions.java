package org.paymob.onlineshop.exceptions;

import java.util.Map;

public class PetExceptions extends RuntimeException {
    private String errorCode;
    private Map<String, String> errorMessage;

    public PetExceptions(Map<String, String> errorMessage) {

        this.errorMessage = errorMessage;
    }
    public Map<String, String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Map<String, String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
