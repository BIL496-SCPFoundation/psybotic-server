package com.scpfoundation.psybotic.server.custom;

public class GeneralResponse {
    private String message;
    private int status;
    private String warning;
    private String error;


    public GeneralResponse() {
    }

    public GeneralResponse(String message, int status, String warning, String error) {
        this.message = message;
        this.status = status;
        this.warning = warning;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
