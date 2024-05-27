package com.example.exp;

public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException() {
        super("Sizga taqiqlangan!");
    }
}
