package com.cluttered.cryptocurrency.models;

import java.util.List;

public class ApiResponse<T> {

    private boolean success;
    private String message;
    private List<T> result;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<T> getResult() {
        return result;
    }
}
